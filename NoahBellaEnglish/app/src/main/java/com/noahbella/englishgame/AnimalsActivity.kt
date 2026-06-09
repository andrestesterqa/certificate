package com.noahbella.englishgame

import com.noahbella.englishgame.model.QuizQuestion

class AnimalsActivity : BaseQuizActivity() {
    override fun getLevelId() = 4
    override fun getLevelName() = "Animals"
    override fun getLevelEmoji() = "🐾"

    override fun createQuestions() = listOf(
        QuizQuestion("What animal is this?", "🐶", "DOG", listOf("CAT", "BIRD", "FISH")),
        QuizQuestion("What animal is this?", "🐱", "CAT", listOf("DOG", "LION", "BEAR")),
        QuizQuestion("What animal is this?", "🐰", "RABBIT", listOf("HAMSTER", "MOUSE", "SQUIRREL")),
        QuizQuestion("What animal is this?", "🐸", "FROG", listOf("TOAD", "LIZARD", "TURTLE")),
        QuizQuestion("What animal is this?", "🐘", "ELEPHANT", listOf("HIPPO", "RHINO", "GIRAFFE")),
        QuizQuestion("What animal is this?", "🦁", "LION", listOf("TIGER", "LEOPARD", "CHEETAH")),
        QuizQuestion("What animal is this?", "🦋", "BUTTERFLY", listOf("BEE", "FLY", "LADYBUG")),
        QuizQuestion("What animal is this?", "🐢", "TURTLE", listOf("FROG", "LIZARD", "SNAKE")),
        QuizQuestion("What animal is this?", "🦜", "PARROT", listOf("EAGLE", "OWL", "PENGUIN")),
        QuizQuestion("What animal is this?", "🐬", "DOLPHIN", listOf("WHALE", "SHARK", "SEAL"))
    )
}
