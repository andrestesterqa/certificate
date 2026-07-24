package com.noahbella.englishgame.model

data class Level(
    val id: Int,
    val name: String,
    val description: String,
    val emoji: String,
    val colorStart: String,
    val colorEnd: String,
    val isUnlocked: Boolean = false,
    val starsEarned: Int = 0
)
