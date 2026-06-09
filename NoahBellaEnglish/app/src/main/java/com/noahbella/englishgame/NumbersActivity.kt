package com.noahbella.englishgame

import com.noahbella.englishgame.model.QuizQuestion

class NumbersActivity : BaseQuizActivity() {
    override fun getLevelId() = 3
    override fun getLevelName() = "Numbers"
    override fun getLevelEmoji() = "🔢"

    override fun createQuestions() = listOf(
        QuizQuestion("How many do you see?", "⭐", "ONE", listOf("TWO", "THREE", "FOUR")),
        QuizQuestion("How many do you see?", "⭐⭐", "TWO", listOf("ONE", "THREE", "FOUR")),
        QuizQuestion("How many do you see?", "⭐⭐⭐", "THREE", listOf("TWO", "FOUR", "FIVE")),
        QuizQuestion("How many do you see?", "🍎🍎🍎🍎", "FOUR", listOf("THREE", "FIVE", "SIX")),
        QuizQuestion("How many do you see?", "🌙🌙🌙🌙🌙", "FIVE", listOf("FOUR", "SIX", "SEVEN")),
        QuizQuestion("How many do you see?", "🐟🐟🐟🐟🐟🐟", "SIX", listOf("FIVE", "SEVEN", "EIGHT")),
        QuizQuestion("How many do you see?", "🌸🌸🌸🌸🌸🌸🌸", "SEVEN", listOf("SIX", "EIGHT", "NINE")),
        QuizQuestion("How many do you see?", "❤️❤️❤️❤️❤️❤️❤️❤️", "EIGHT", listOf("SEVEN", "NINE", "TEN")),
        QuizQuestion("How many do you see?", "☀️☀️☀️☀️☀️☀️☀️☀️☀️", "NINE", listOf("SEVEN", "EIGHT", "TEN")),
        QuizQuestion("How many do you see?", "🔵🔵🔵🔵🔵🔵🔵🔵🔵🔵", "TEN", listOf("EIGHT", "NINE", "ELEVEN"))
    )
}
