package com.noahbella.englishgame.model

data class QuizQuestion(
    val questionText: String,
    val questionDisplay: String,
    val correctAnswer: String,
    val wrongAnswers: List<String>
) {
    fun getAllAnswers(): List<String> = (wrongAnswers + correctAnswer).shuffled()
}
