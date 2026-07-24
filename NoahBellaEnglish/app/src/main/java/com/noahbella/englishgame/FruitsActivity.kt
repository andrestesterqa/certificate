package com.noahbella.englishgame

import com.noahbella.englishgame.model.QuizQuestion

class FruitsActivity : BaseQuizActivity() {
    override fun getLevelId() = 5
    override fun getLevelName() = "El Reino de la Comida"
    override fun getLevelEmoji() = "🍕"
    override fun getAdventureBackground() = R.drawable.bg_adventure_5

    override fun getStoryIntro() =
        "🍕 ¡Bienvenido al Reino de la Comida!\n\nEl rey y la reina prepararon una FIESTA MÁGICA donde las comidas cobran vida.\n\n¡Escucha cada alimento y elige su primera letra!"

    override fun getAdventureEnding() =
        "👑 ¡CONQUISTASTE EL REINO DE LA COMIDA!\n\nNoah y Bella te nombran CHEF SUPREMO del reino. ¡Última aventura: EL CASTILLO MÁGICO! 🏰"

    override fun getMilestones() = mapOf(
        2 to "🍰 ¡El chef mágico te regaló su RECETA SECRETA!\n\nCon ella puedes crear platillos mágicos 🧑‍🍳✨",
        5 to "🍕 ¡La pizza parlante te reveló el INGREDIENTE MISTERIOSO del reino!\n\n¡Solo los más listos lo conocen! 🔑"
    )

    override fun createQuestions() = listOf(
        QuizQuestion("ORANGE", "🍊", "O", listOf("A", "G", "P")),
        QuizQuestion("PIZZA", "🍕", "P", listOf("B", "T", "Z")),
        QuizQuestion("QUINCE", "🍐", "Q", listOf("C", "P", "K")),
        QuizQuestion("RICE", "🍚", "R", listOf("I", "C", "P")),
        QuizQuestion("SOUP", "🍲", "S", listOf("C", "P", "T")),
        QuizQuestion("TACO", "🌮", "T", listOf("A", "C", "S")),
        QuizQuestion("UDON", "🍜", "U", listOf("A", "B", "I")),
        QuizQuestion("VANILLA", "🍦", "V", listOf("B", "N", "W")),
        QuizQuestion("WAFFLE", "🧇", "W", listOf("M", "F", "V")),
        QuizQuestion("YOGURT", "🥛", "Y", listOf("G", "T", "Z"))
    )
}
