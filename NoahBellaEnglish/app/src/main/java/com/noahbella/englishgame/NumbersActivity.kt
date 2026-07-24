package com.noahbella.englishgame

import com.noahbella.englishgame.model.QuizQuestion

class NumbersActivity : BaseQuizActivity() {
    override fun getLevelId() = 3
    override fun getLevelName() = "La Aventura Espacial"
    override fun getLevelEmoji() = "🚀"
    override fun getAdventureBackground() = R.drawable.bg_adventure_3

    override fun getStoryIntro() =
        "🚀 ¡3... 2... 1... DESPEGUE!\n\nNoah y Bella te necesitan en su nave espacial para explorar las galaxias más lejanas.\n\n¡Escucha cada palabra del cosmos y elige su primera letra!"

    override fun getAdventureEnding() =
        "🌌 ¡EXPLORASTE TODO EL UNIVERSO!\n\nNoah y Bella son los mejores astronautas gracias a ti. ¡La SELVA SALVAJE te espera! 🦁"

    override fun getMilestones() = mapOf(
        2 to "☄️ ¡Un cometa mágico cruzó tu camino!\n\nTe dejó POLVO DE ESTRELLAS. ¡Tu poder de aprendizaje se DUPLICÓ! ⭐⭐",
        5 to "👽 ¡Un alienígena amigable te entregó un CRISTAL GALÁCTICO!\n\nCon él, los misterios del universo son tuyos 🔮"
    )

    override fun createQuestions() = listOf(
        QuizQuestion("UNIVERSE", "🌌", "U", listOf("A", "I", "O")),
        QuizQuestion("VENUS", "🪐", "V", listOf("M", "P", "W")),
        QuizQuestion("WONDER", "🌟", "W", listOf("M", "N", "V")),
        QuizQuestion("XYLOPHONE", "🎵", "X", listOf("Z", "S", "Y")),
        QuizQuestion("YELLOW STAR", "⭐", "Y", listOf("W", "Z", "J")),
        QuizQuestion("ZERO", "0️⃣", "Z", listOf("S", "R", "O")),
        QuizQuestion("ASTEROID", "☄️", "A", listOf("O", "E", "I")),
        QuizQuestion("BLACK HOLE", "🕳️", "B", listOf("H", "D", "P")),
        QuizQuestion("COMET", "🌠", "C", listOf("K", "M", "T")),
        QuizQuestion("DUST", "💫", "D", listOf("B", "T", "S"))
    )
}
