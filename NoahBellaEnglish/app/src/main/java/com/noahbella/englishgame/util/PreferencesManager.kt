package com.noahbella.englishgame.util

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun getLevelStars(levelId: Int): Int = prefs.getInt(KEY_STARS + levelId, 0)

    fun saveLevelStars(levelId: Int, stars: Int) {
        if (stars > getLevelStars(levelId)) {
            prefs.edit().putInt(KEY_STARS + levelId, stars).apply()
        }
    }

    fun isLevelUnlocked(levelId: Int): Boolean {
        if (levelId == 1) return true
        return getLevelStars(levelId - 1) >= 1
    }

    fun getTotalStars(): Int = (1..6).sumOf { getLevelStars(it) }

    companion object {
        private const val PREFS_NAME = "noah_bella_prefs"
        private const val KEY_STARS = "stars_level_"
    }
}
