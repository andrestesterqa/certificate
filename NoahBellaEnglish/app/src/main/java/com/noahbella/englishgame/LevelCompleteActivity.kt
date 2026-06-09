package com.noahbella.englishgame

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.noahbella.englishgame.databinding.ActivityLevelCompleteBinding

class LevelCompleteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLevelCompleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("DEPRECATION")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityLevelCompleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val stars = intent.getIntExtra(EXTRA_STARS, 0)
        val score = intent.getIntExtra(EXTRA_SCORE, 0)
        val total = intent.getIntExtra(EXTRA_TOTAL, 0)
        val levelName = intent.getStringExtra(EXTRA_LEVEL_NAME) ?: ""
        val levelEmoji = intent.getStringExtra(EXTRA_LEVEL_EMOJI) ?: "⭐"

        binding.tvLevelEmoji.text = levelEmoji
        binding.tvLevelName.text = "$levelName Complete!"
        binding.tvScore.text = "$score / $total Correct"
        binding.tvStars.text = "⭐".repeat(stars) + "☆".repeat(3 - stars)

        binding.tvMessage.text = when (stars) {
            3 -> "🏆 Perfect! Noah & Bella are proud of you!"
            2 -> "🌟 Great job! You're learning fast!"
            1 -> "😊 Good try! Practice makes perfect!"
            else -> "💪 Don't give up! Try again!"
        }

        binding.tvNoahSays.text = if (stars >= 2) "Noah: \"You're amazing! 😺\"" else "Noah: \"You can do it! 😺\""
        binding.tvBellaSays.text = if (stars >= 2) "Bella: \"Keep it up! 🐱\"" else "Bella: \"Let's try again! 🐱\""

        val bounce = AnimationUtils.loadAnimation(this, R.anim.bounce)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.tvStars.startAnimation(bounce)
        binding.cardResult.startAnimation(fadeIn)

        binding.btnPlayAgain.setOnClickListener { finish() }

        binding.btnLevels.setOnClickListener {
            val intent = Intent(this, LevelsActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }

        binding.btnHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }

    companion object {
        const val EXTRA_STARS = "extra_stars"
        const val EXTRA_SCORE = "extra_score"
        const val EXTRA_TOTAL = "extra_total"
        const val EXTRA_LEVEL_NAME = "extra_level_name"
        const val EXTRA_LEVEL_EMOJI = "extra_level_emoji"
    }
}
