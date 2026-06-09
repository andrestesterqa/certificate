package com.noahbella.englishgame

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.noahbella.englishgame.adapter.LevelAdapter
import com.noahbella.englishgame.databinding.ActivityLevelsBinding
import com.noahbella.englishgame.model.Level
import com.noahbella.englishgame.util.PreferencesManager

class LevelsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLevelsBinding
    private lateinit var prefs: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("DEPRECATION")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityLevelsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefs = PreferencesManager(this)

        binding.btnBack.setOnClickListener { finish() }

        binding.rvLevels.layoutManager = GridLayoutManager(this, 2)
    }

    override fun onResume() {
        super.onResume()
        setupLevelGrid()
    }

    private fun setupLevelGrid() {
        val levels = buildLevels()
        val adapter = LevelAdapter(levels) { level ->
            val activityClass = when (level.id) {
                1 -> AlphabetActivity::class.java
                2 -> ColorsActivity::class.java
                3 -> NumbersActivity::class.java
                4 -> AnimalsActivity::class.java
                5 -> FruitsActivity::class.java
                6 -> BodyPartsActivity::class.java
                else -> return@LevelAdapter
            }
            startActivity(Intent(this, activityClass))
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
        binding.rvLevels.adapter = adapter
    }

    private fun buildLevels() = listOf(
        Level(1, "Alphabet", "Learn A-Z letters!", "🔤", "#FF6B6B", "#FF8E53",
            prefs.isLevelUnlocked(1), prefs.getLevelStars(1)),
        Level(2, "Colors", "Know your colors!", "🎨", "#4ECDC4", "#44A08D",
            prefs.isLevelUnlocked(2), prefs.getLevelStars(2)),
        Level(3, "Numbers", "Count to ten!", "🔢", "#96E6A1", "#3D9970",
            prefs.isLevelUnlocked(3), prefs.getLevelStars(3)),
        Level(4, "Animals", "Meet the animals!", "🐾", "#FFD93D", "#FF9F1C",
            prefs.isLevelUnlocked(4), prefs.getLevelStars(4)),
        Level(5, "Fruits", "Taste the fruits!", "🍎", "#A8E6CF", "#27AE60",
            prefs.isLevelUnlocked(5), prefs.getLevelStars(5)),
        Level(6, "Body Parts", "Know your body!", "🫀", "#F8B4C8", "#E84393",
            prefs.isLevelUnlocked(6), prefs.getLevelStars(6))
    )
}
