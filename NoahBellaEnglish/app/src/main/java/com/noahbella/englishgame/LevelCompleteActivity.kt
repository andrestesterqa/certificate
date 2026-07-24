package com.noahbella.englishgame

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
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
        val levelId = intent.getIntExtra(EXTRA_LEVEL_ID, 1)
        val levelName = intent.getStringExtra(EXTRA_LEVEL_NAME) ?: ""
        val levelEmoji = intent.getStringExtra(EXTRA_LEVEL_EMOJI) ?: "⭐"
        val adventureEnding = intent.getStringExtra(EXTRA_ADVENTURE_ENDING) ?: ""

        binding.tvLevelEmoji.text = levelEmoji
        binding.tvLevelName.text = "$levelName\n¡Completado!"
        binding.tvScore.text = "$score / $total Correctas"
        binding.tvStars.text = "⭐".repeat(stars) + "☆".repeat(3 - stars)

        binding.tvMessage.text = when (stars) {
            3 -> "🏆 ¡Perfecto! ¡Eres un genio del inglés!"
            2 -> "🌟 ¡Excelente! ¡Casi lo logras!"
            1 -> "😊 ¡Buen intento! ¡La práctica te hace maestro!"
            else -> "💪 ¡No te rindas! ¡Sigue intentando!"
        }

        if (stars == 3) {
            binding.tvAdventureEnding.text = if (adventureEnding.isNotEmpty()) adventureEnding else ""
            binding.tvAdventureEnding.setTextColor(Color.parseColor("#5B4AE8"))
            if (levelId < 6) {
                binding.btnNextLevel.visibility = View.VISIBLE
                binding.btnNextLevel.text = "🚀 ¡Siguiente Aventura!"
            } else {
                binding.btnNextLevel.visibility = View.VISIBLE
                binding.btnNextLevel.text = "🏆 ¡Completaste el Juego!"
            }
        } else {
            binding.tvAdventureEnding.text = "🎯 ¡Necesitas 10/10 para avanzar!\nSigue practicando, ¡tú puedes! 💪"
            binding.tvAdventureEnding.setTextColor(Color.parseColor("#E53935"))
            binding.btnNextLevel.visibility = View.GONE
        }

        binding.tvNoahSays.text = if (stars == 3) "Noah: \"¡Eres increíble! 😺\"" else "Noah: \"¡Tú puedes lograrlo! 😺\""
        binding.tvBellaSays.text = if (stars == 3) "Bella: \"¡10/10 campeón! 🐱\"" else "Bella: \"¡Inténtalo de nuevo! 🐱\""

        val bounce = AnimationUtils.loadAnimation(this, R.anim.bounce)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.tvStars.startAnimation(bounce)
        binding.cardResult.startAnimation(fadeIn)

        binding.btnNextLevel.setOnClickListener {
            startActivity(Intent(this, LevelsActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            })
            finish()
        }

        binding.btnPlayAgain.setOnClickListener { finish() }

        binding.btnLevels.setOnClickListener {
            startActivity(Intent(this, LevelsActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            })
            finish()
        }

        binding.btnHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            })
            finish()
        }
    }

    companion object {
        const val EXTRA_STARS = "extra_stars"
        const val EXTRA_SCORE = "extra_score"
        const val EXTRA_TOTAL = "extra_total"
        const val EXTRA_LEVEL_ID = "extra_level_id"
        const val EXTRA_LEVEL_NAME = "extra_level_name"
        const val EXTRA_LEVEL_EMOJI = "extra_level_emoji"
        const val EXTRA_ADVENTURE_ENDING = "extra_adventure_ending"
    }
}
