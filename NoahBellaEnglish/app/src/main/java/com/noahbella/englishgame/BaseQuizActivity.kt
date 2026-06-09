package com.noahbella.englishgame

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.noahbella.englishgame.databinding.ActivityQuizBinding
import com.noahbella.englishgame.model.QuizQuestion
import com.noahbella.englishgame.util.PreferencesManager

abstract class BaseQuizActivity : AppCompatActivity() {

    protected lateinit var binding: ActivityQuizBinding
    protected lateinit var prefs: PreferencesManager

    private var questions: List<QuizQuestion> = emptyList()
    private var currentIndex = 0
    private var correctCount = 0
    private var answered = false

    abstract fun getLevelId(): Int
    abstract fun getLevelName(): String
    abstract fun getLevelEmoji(): String
    abstract fun createQuestions(): List<QuizQuestion>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("DEPRECATION")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefs = PreferencesManager(this)
        questions = createQuestions().shuffled()

        setupUI()
        loadQuestion()
    }

    private fun setupUI() {
        binding.tvLevelTitle.text = "${getLevelEmoji()} ${getLevelName()}"
        binding.progressBar.max = questions.size
        binding.btnBack.setOnClickListener { finish() }

        val answerButtons = answerButtons()
        answerButtons.forEach { btn ->
            btn.setOnClickListener {
                if (!answered) onAnswerSelected(btn.text.toString(), btn)
            }
        }
    }

    private fun loadQuestion() {
        if (currentIndex >= questions.size) {
            finishGame()
            return
        }

        answered = false
        val q = questions[currentIndex]

        resetButtons()
        binding.tvFeedback.visibility = View.INVISIBLE

        binding.tvQuestionText.text = q.questionText
        binding.tvQuestionDisplay.text = q.questionDisplay
        binding.tvProgress.text = "${currentIndex + 1} / ${questions.size}"
        binding.progressBar.progress = currentIndex + 1

        val answers = q.getAllAnswers()
        binding.btnA.text = answers[0]
        binding.btnB.text = answers[1]
        binding.btnC.text = answers[2]
        binding.btnD.text = answers[3]

        val anim = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.tvQuestionDisplay.startAnimation(anim)
        binding.cardQuestion.startAnimation(anim)
    }

    private fun onAnswerSelected(selected: String, tappedBtn: Button) {
        answered = true
        val correct = questions[currentIndex].correctAnswer

        if (selected == correct) {
            correctCount++
            tappedBtn.setBackgroundColor(ContextCompat.getColor(this, R.color.correct_green))
            tappedBtn.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.tvFeedback.text = correctMessages.random()
            binding.tvFeedback.setTextColor(ContextCompat.getColor(this, R.color.correct_green))
            val bounce = AnimationUtils.loadAnimation(this, R.anim.bounce)
            binding.tvQuestionDisplay.startAnimation(bounce)
        } else {
            tappedBtn.setBackgroundColor(ContextCompat.getColor(this, R.color.wrong_red))
            tappedBtn.setTextColor(ContextCompat.getColor(this, R.color.white))
            answerButtons().firstOrNull { it.text == correct }?.let { rightBtn ->
                rightBtn.setBackgroundColor(ContextCompat.getColor(this, R.color.correct_green))
                rightBtn.setTextColor(ContextCompat.getColor(this, R.color.white))
            }
            binding.tvFeedback.text = wrongMessages.random()
            binding.tvFeedback.setTextColor(ContextCompat.getColor(this, R.color.wrong_red))
            val shake = AnimationUtils.loadAnimation(this, R.anim.shake)
            tappedBtn.startAnimation(shake)
        }

        binding.tvFeedback.visibility = View.VISIBLE

        Handler(Looper.getMainLooper()).postDelayed({
            currentIndex++
            loadQuestion()
        }, 1600)
    }

    private fun resetButtons() {
        val defaultBg = ContextCompat.getColor(this, R.color.answer_button_bg)
        val defaultText = ContextCompat.getColor(this, R.color.text_dark)
        answerButtons().forEach { btn ->
            btn.setBackgroundColor(defaultBg)
            btn.setTextColor(defaultText)
        }
    }

    private fun answerButtons() = listOf(binding.btnA, binding.btnB, binding.btnC, binding.btnD)

    private fun finishGame() {
        val stars = when {
            correctCount == questions.size -> 3
            correctCount >= questions.size * 0.8 -> 2
            correctCount >= questions.size * 0.6 -> 1
            else -> 0
        }
        prefs.saveLevelStars(getLevelId(), stars)

        val intent = Intent(this, LevelCompleteActivity::class.java).apply {
            putExtra(LevelCompleteActivity.EXTRA_STARS, stars)
            putExtra(LevelCompleteActivity.EXTRA_SCORE, correctCount)
            putExtra(LevelCompleteActivity.EXTRA_TOTAL, questions.size)
            putExtra(LevelCompleteActivity.EXTRA_LEVEL_NAME, getLevelName())
            putExtra(LevelCompleteActivity.EXTRA_LEVEL_EMOJI, getLevelEmoji())
        }
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }

    companion object {
        private val correctMessages = listOf(
            "🎉 Excellent!", "⭐ Amazing!", "🌟 Perfect!", "🎊 Great job!", "🏆 Wonderful!"
        )
        private val wrongMessages = listOf(
            "😊 Try again!", "💪 Keep going!", "🤔 Almost there!", "❤️ Don't give up!"
        )
    }
}
