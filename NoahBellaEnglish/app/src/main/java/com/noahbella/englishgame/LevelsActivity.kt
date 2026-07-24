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
        Level(1, "El Bosque Encantado", "Palabras del bosque mágico 🌲", "🌲", "#1B5E20", "#66BB6A",
            prefs.isLevelUnlocked(1), prefs.getLevelStars(1)),
        Level(2, "El Océano Misterioso", "Secretos del mar profundo 🌊", "🌊", "#01579B", "#4FC3F7",
            prefs.isLevelUnlocked(2), prefs.getLevelStars(2)),
        Level(3, "La Aventura Espacial", "Explora las galaxias 🚀", "🚀", "#0D0D2B", "#311B92",
            prefs.isLevelUnlocked(3), prefs.getLevelStars(3)),
        Level(4, "La Selva Salvaje", "Safari con animales exóticos 🦁", "🦁", "#33691E", "#FF6F00",
            prefs.isLevelUnlocked(4), prefs.getLevelStars(4)),
        Level(5, "El Reino de la Comida", "¡Fiesta de sabores! 🍕", "🍕", "#BF360C", "#FF8F00",
            prefs.isLevelUnlocked(5), prefs.getLevelStars(5)),
        Level(6, "El Castillo Mágico", "¡Rompe el hechizo del dragón! 🏰", "🏰", "#4A148C", "#AD1457",
            prefs.isLevelUnlocked(6), prefs.getLevelStars(6))
    )
}
