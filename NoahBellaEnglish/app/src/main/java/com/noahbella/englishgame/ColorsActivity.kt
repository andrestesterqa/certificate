package com.noahbella.englishgame

import com.noahbella.englishgame.model.QuizQuestion

class ColorsActivity : BaseQuizActivity() {
    override fun getLevelId() = 2
    override fun getLevelName() = "El Océano Misterioso"
    override fun getLevelEmoji() = "🌊"
    override fun getAdventureBackground() = R.drawable.bg_adventure_2

    override fun getStoryIntro() =
        "🌊 ¡El Océano Misterioso te llama!\n\nNoah y Bella tienen un submarino mágico listo para explorar las profundidades.\n\n¡Escucha cada palabra del mar y elige su primera letra!"

    override fun getAdventureEnding() =
        "🏆 ¡CONQUISTASTE EL OCÉANO MISTERIOSO!\n\nNoah y Bella encontraron el tesoro del fondo del mar. ¡Siguiente parada: LA AVENTURA ESPACIAL! 🚀"

    override fun getMilestones() = mapOf(
        2 to "🐠 ¡Guau!\n\nUn pez arcoíris te entregó la LLAVE DEL COFRE SUBMARINO.\n¿Qué secretos guarda el océano? 🔑",
        5 to "🐙 ¡Un pulpo sabio compartió su PERGAMINO MÁGICO contigo!\n\nDice que hay un tesoro escondido muy cerca... 📜"
    )

    override fun createQuestions() = listOf(
        QuizQuestion("KELP", "🌊", "K", listOf("C", "P", "L")),
        QuizQuestion("LOBSTER", "🦞", "L", listOf("B", "R", "S")),
        QuizQuestion("MOON", "🌙", "M", listOf("N", "S", "B")),
        QuizQuestion("NET", "🕸️", "N", listOf("M", "T", "W")),
        QuizQuestion("OCTOPUS", "🐙", "O", listOf("A", "C", "P")),
        QuizQuestion("PEARL", "💎", "P", listOf("B", "R", "L")),
        QuizQuestion("QUEEN", "👑", "Q", listOf("K", "P", "W")),
        QuizQuestion("RAY", "🐟", "R", listOf("A", "P", "W")),
        QuizQuestion("SHARK", "🦈", "S", listOf("H", "T", "C")),
        QuizQuestion("TURTLE", "🐢", "T", listOf("S", "R", "L"))
    )
}
