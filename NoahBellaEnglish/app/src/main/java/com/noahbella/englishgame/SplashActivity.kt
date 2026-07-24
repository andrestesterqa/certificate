package com.noahbella.englishgame

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.noahbella.englishgame.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val handler = Handler(Looper.getMainLooper())
    private var dotCount = 0

    private val loadingRunnable = object : Runnable {
        override fun run() {
            dotCount = (dotCount % 3) + 1
            binding.tvLoading.text = "Cargando" + ".".repeat(dotCount)
            handler.postDelayed(this, 500)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("DEPRECATION")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bounce = AnimationUtils.loadAnimation(this, R.anim.bounce)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)

        binding.tvNoahChar.startAnimation(bounce)
        binding.tvBellaChar.startAnimation(bounce)
        binding.bannerLayout.startAnimation(fadeIn)
        binding.tvLoading.startAnimation(slideUp)

        handler.post(loadingRunnable)

        handler.postDelayed({
            handler.removeCallbacks(loadingRunnable)
            startActivity(Intent(this, HomeActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, 3000)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(loadingRunnable)
    }
}
