package com.noahbella.englishgame

import com.noahbella.englishgame.model.QuizQuestion

class FruitsActivity : BaseQuizActivity() {
    override fun getLevelId() = 5
    override fun getLevelName() = "Fruits"
    override fun getLevelEmoji() = "🍎"

    override fun createQuestions() = listOf(
        QuizQuestion("What fruit is this?", "🍎", "APPLE", listOf("PEAR", "MANGO", "CHERRY")),
        QuizQuestion("What fruit is this?", "🍌", "BANANA", listOf("MANGO", "PAPAYA", "MELON")),
        QuizQuestion("What fruit is this?", "🍊", "ORANGE", listOf("LEMON", "LIME", "GRAPEFRUIT")),
        QuizQuestion("What fruit is this?", "🍇", "GRAPES", listOf("BERRIES", "PLUMS", "CHERRIES")),
        QuizQuestion("What fruit is this?", "🍓", "STRAWBERRY", listOf("RASPBERRY", "CHERRY", "CRANBERRY")),
        QuizQuestion("What fruit is this?", "🍍", "PINEAPPLE", listOf("COCONUT", "MANGO", "PAPAYA")),
        QuizQuestion("What fruit is this?", "🥝", "KIWI", listOf("LIME", "AVOCADO", "GRAPE")),
        QuizQuestion("What fruit is this?", "🍒", "CHERRY", listOf("GRAPE", "BERRY", "PLUM")),
        QuizQuestion("What fruit is this?", "🍑", "PEACH", listOf("APRICOT", "MANGO", "PLUM")),
        QuizQuestion("What fruit is this?", "🍋", "LEMON", listOf("LIME", "ORANGE", "GRAPEFRUIT"))
    )
}
