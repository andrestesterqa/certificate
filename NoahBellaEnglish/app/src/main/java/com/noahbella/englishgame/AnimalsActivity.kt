package com.noahbella.englishgame

import com.noahbella.englishgame.model.QuizQuestion

class AnimalsActivity : BaseQuizActivity() {
    override fun getLevelId() = 4
    override fun getLevelName() = "La Selva Salvaje"
    override fun getLevelEmoji() = "🦁"
    override fun getAdventureBackground() = R.drawable.bg_adventure_4

    override fun getStoryIntro() =
        "🦁 ¡La Selva Salvaje está llena de misterios!\n\nLos animales más exóticos del mundo guardan secretos increíbles para Noah y Bella.\n\n¡Escucha cada animal y elige su primera letra!"

    override fun getAdventureEnding() =
        "🎖️ ¡DOMASTE LA SELVA SALVAJE!\n\nNoah y Bella te coronaron como el GRAN EXPLORADOR. ¡El REINO DE LA COMIDA te aguarda! 🍕"

    override fun getMilestones() = mapOf(
        2 to "🦜 ¡Un loro sabio te enseñó el GRITO SECRETO DE LA SELVA!\n\nAhora los animales confían en ti 🌿",
        5 to "🐆 ¡El jaguar guardián te entregó su AMULETO DE LA SELVA!\n\n¡Eres ya un explorador legendario! 🏅"
    )

    override fun createQuestions() = listOf(
        QuizQuestion("ELEPHANT", "🐘", "E", listOf("I", "A", "O")),
        QuizQuestion("FLAMINGO", "🦩", "F", listOf("B", "L", "P")),
        QuizQuestion("GORILLA", "🦍", "G", listOf("J", "R", "B")),
        QuizQuestion("HIPPO", "🦛", "H", listOf("B", "P", "W")),
        QuizQuestion("IGUANA", "🦎", "I", listOf("E", "A", "U")),
        QuizQuestion("JAGUAR", "🐆", "J", listOf("G", "P", "Y")),
        QuizQuestion("KANGAROO", "🦘", "K", listOf("C", "G", "R")),
        QuizQuestion("LEMUR", "🐒", "L", listOf("M", "R", "B")),
        QuizQuestion("MONKEY", "🐵", "M", listOf("N", "B", "K")),
        QuizQuestion("NEST", "🪺", "N", listOf("M", "T", "S"))
    )
}
