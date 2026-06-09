package com.noahbella.englishgame

import com.noahbella.englishgame.model.QuizQuestion

class AlphabetActivity : BaseQuizActivity() {
    override fun getLevelId() = 1
    override fun getLevelName() = "Alphabet"
    override fun getLevelEmoji() = "🔤"

    override fun createQuestions() = listOf(
        QuizQuestion("What letter does APPLE start with?", "🍎\nAPPLE", "A", listOf("B", "C", "D")),
        QuizQuestion("What letter does BALL start with?", "⚽\nBALL", "B", listOf("A", "C", "P")),
        QuizQuestion("What letter does CAT start with?", "🐱\nCAT", "C", listOf("A", "B", "K")),
        QuizQuestion("What letter does DOG start with?", "🐶\nDOG", "D", listOf("A", "B", "G")),
        QuizQuestion("What letter does EGG start with?", "🥚\nEGG", "E", listOf("A", "D", "I")),
        QuizQuestion("What letter does FISH start with?", "🐟\nFISH", "F", listOf("B", "E", "P")),
        QuizQuestion("What letter does GOAT start with?", "🐐\nGOAT", "G", listOf("C", "J", "Q")),
        QuizQuestion("What letter does HOUSE start with?", "🏠\nHOUSE", "H", listOf("A", "J", "W")),
        QuizQuestion("What letter does ICE start with?", "🧊\nICE", "I", listOf("H", "J", "E")),
        QuizQuestion("What letter does JAR start with?", "🫙\nJAR", "J", listOf("G", "I", "Y"))
    )
}
