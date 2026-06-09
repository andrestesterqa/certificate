package com.noahbella.englishgame

import com.noahbella.englishgame.model.QuizQuestion

class ColorsActivity : BaseQuizActivity() {
    override fun getLevelId() = 2
    override fun getLevelName() = "Colors"
    override fun getLevelEmoji() = "🎨"

    override fun createQuestions() = listOf(
        QuizQuestion("What color is this?", "🔴", "RED", listOf("BLUE", "GREEN", "YELLOW")),
        QuizQuestion("What color is this?", "🔵", "BLUE", listOf("RED", "PINK", "ORANGE")),
        QuizQuestion("What color is this?", "🟢", "GREEN", listOf("PURPLE", "BLUE", "RED")),
        QuizQuestion("What color is this?", "🟡", "YELLOW", listOf("ORANGE", "WHITE", "PINK")),
        QuizQuestion("What color is this?", "🟠", "ORANGE", listOf("RED", "YELLOW", "BROWN")),
        QuizQuestion("What color is this?", "🟣", "PURPLE", listOf("PINK", "BLUE", "GRAY")),
        QuizQuestion("What color is this?", "⚫", "BLACK", listOf("WHITE", "GRAY", "BROWN")),
        QuizQuestion("What color is this?", "⚪", "WHITE", listOf("GRAY", "BLACK", "SILVER")),
        QuizQuestion("What color is this?", "🩷", "PINK", listOf("RED", "PURPLE", "ORANGE")),
        QuizQuestion("What color is this?", "🟤", "BROWN", listOf("ORANGE", "RED", "GRAY"))
    )
}
