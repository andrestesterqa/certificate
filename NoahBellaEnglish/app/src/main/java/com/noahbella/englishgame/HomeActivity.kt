package com.noahbella.englishgame

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.noahbella.englishgame.databinding.ActivityHomeBinding
import com.noahbella.englishgame.util.PreferencesManager

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var prefs: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("DEPRECATION")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefs = PreferencesManager(this)

        val slideLeft = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
        val slideRight = AnimationUtils.loadAnimation(this, R.anim.slide_in_right)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)

        binding.cardNoah.startAnimation(slideLeft)
        binding.cardBella.startAnimation(slideRight)
        binding.tvTitle.startAnimation(fadeIn)
        binding.btnPlay.startAnimation(slideUp)

        binding.btnPlay.setOnClickListener {
            startActivity(Intent(this, LevelsActivity::class.java))
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
    }

    override fun onResume() {
        super.onResume()
        val total = prefs.getTotalStars()
        binding.tvTotalStars.text = "⭐ $total / 18 Stars Collected"
    }
}
