package com.noahbella.englishgame

import com.noahbella.englishgame.model.QuizQuestion

class BodyPartsActivity : BaseQuizActivity() {
    override fun getLevelId() = 6
    override fun getLevelName() = "Body Parts"
    override fun getLevelEmoji() = "🫀"

    override fun createQuestions() = listOf(
        QuizQuestion("What part of the body is this?", "👁️", "EYE", listOf("EAR", "NOSE", "MOUTH")),
        QuizQuestion("What part of the body is this?", "👂", "EAR", listOf("EYE", "NOSE", "CHEEK")),
        QuizQuestion("What part of the body is this?", "👃", "NOSE", listOf("MOUTH", "CHIN", "FOREHEAD")),
        QuizQuestion("What part of the body is this?", "👄", "MOUTH", listOf("NOSE", "LIP", "TONGUE")),
        QuizQuestion("What part of the body is this?", "✋", "HAND", listOf("FOOT", "FINGER", "ARM")),
        QuizQuestion("What part of the body is this?", "🦷", "TOOTH", listOf("TONGUE", "LIP", "GUM")),
        QuizQuestion("What part of the body is this?", "💪", "ARM", listOf("LEG", "SHOULDER", "ELBOW")),
        QuizQuestion("What part of the body is this?", "🦵", "LEG", listOf("ARM", "FOOT", "KNEE")),
        QuizQuestion("What part of the body is this?", "👣", "FOOT", listOf("HAND", "TOE", "HEEL")),
        QuizQuestion("What part of the body is this?", "🧠", "BRAIN", listOf("HEART", "LUNG", "KIDNEY"))
    )
}
