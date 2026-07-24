package com.noahbella.englishgame.model

data class QuizQuestion(
    val englishWord: String,
    val questionDisplay: String,
    val correctAnswer: String,
    val wrongAnswers: List<String>
) {
    fun getAllAnswers(): List<String> = (wrongAnswers + correctAnswer).shuffled()
}
