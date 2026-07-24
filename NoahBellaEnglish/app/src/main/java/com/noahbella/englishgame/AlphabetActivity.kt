package com.noahbella.englishgame

import com.noahbella.englishgame.model.QuizQuestion

class AlphabetActivity : BaseQuizActivity() {
    override fun getLevelId() = 1
    override fun getLevelName() = "El Bosque Encantado"
    override fun getLevelEmoji() = "🌲"
    override fun getAdventureBackground() = R.drawable.bg_adventure_1

    override fun getStoryIntro() =
        "🌲 ¡El Bosque Encantado despertó!\n\nNoah y Bella necesitan tu ayuda para aprender las palabras mágicas del bosque.\n\n¡Escucha cada palabra y elige la primera letra en inglés!"

    override fun getAdventureEnding() =
        "🎉 ¡DESBLOQUEASTE EL TESORO DEL BOSQUE ENCANTADO!\n\nNoah y Bella bailan de alegría bajo los árboles. ¡Prepárate para el OCÉANO MISTERIOSO! 🌊"

    override fun getMilestones() = mapOf(
        2 to "🦋 ¡Increíble!\n\nUna mariposa mágica te entregó el PRIMER TROZO del mapa del tesoro.\n¡Sigue adelante! 🗺️",
        5 to "🌟 ¡Fantástico!\n\nEl árbol sabio del bosque te reveló un SECRETO MISTERIOSO...\n¡El tesoro está muy cerca! 🏆"
    )

    override fun createQuestions() = listOf(
        QuizQuestion("APPLE", "🍎", "A", listOf("B", "C", "D")),
        QuizQuestion("BEAR", "🐻", "B", listOf("A", "C", "P")),
        QuizQuestion("CAT", "🐱", "C", listOf("A", "B", "K")),
        QuizQuestion("DEER", "🦌", "D", listOf("B", "E", "T")),
        QuizQuestion("EGG", "🥚", "E", listOf("A", "I", "O")),
        QuizQuestion("FROG", "🐸", "F", listOf("B", "R", "G")),
        QuizQuestion("GOAT", "🐐", "G", listOf("C", "J", "Q")),
        QuizQuestion("HAWK", "🦅", "H", listOf("A", "K", "W")),
        QuizQuestion("IVY", "🌿", "I", listOf("E", "A", "U")),
        QuizQuestion("JAY", "🐦", "J", listOf("G", "Y", "I"))
    )
}
