package com.noahbella.englishgame

import com.noahbella.englishgame.model.QuizQuestion

class BodyPartsActivity : BaseQuizActivity() {
    override fun getLevelId() = 6
    override fun getLevelName() = "El Castillo Mágico"
    override fun getLevelEmoji() = "🏰"
    override fun getAdventureBackground() = R.drawable.bg_adventure_6

    override fun getStoryIntro() =
        "🏰 ¡El Castillo Mágico es el reto final!\n\nUn dragón encantado lanzó un hechizo sobre Noah y Bella. ¡Solo tú puedes romperlo!\n\n¡Escucha cada palabra del castillo y elige su primera letra!"

    override fun getAdventureEnding() =
        "🎊 ¡ROMPISTE EL ENCANTAMIENTO!\n\n¡El dragón fue liberado y se convirtió en amigo de Noah y Bella!\n\n¡ERES EL GRAN MAESTRO DEL INGLÉS! 🏆👑"

    override fun getMilestones() = mapOf(
        2 to "⚔️ ¡El caballero guardián se rindió ante tu sabiduría!\n\nTe entregó la ESPADA MÁGICA del castillo 🗡️✨",
        5 to "🧙 ¡El mago del castillo te reveló el HECHIZO SECRETO!\n\nYa casi rompes el encantamiento del dragón... 🔮🐉"
    )

    override fun createQuestions() = listOf(
        QuizQuestion("KNIGHT", "🤺", "K", listOf("N", "G", "T")),
        QuizQuestion("LANTERN", "🏮", "L", listOf("N", "T", "R")),
        QuizQuestion("MAGIC", "🔮", "M", listOf("G", "A", "W")),
        QuizQuestion("NIGHT", "🌙", "N", listOf("G", "K", "T")),
        QuizQuestion("OWL", "🦉", "O", listOf("W", "A", "E")),
        QuizQuestion("POTION", "🧪", "P", listOf("B", "O", "T")),
        QuizQuestion("QUEST", "🗺️", "Q", listOf("S", "K", "P")),
        QuizQuestion("RING", "💍", "R", listOf("G", "N", "K")),
        QuizQuestion("SWORD", "⚔️", "S", listOf("W", "D", "T")),
        QuizQuestion("THRONE", "👑", "T", listOf("H", "R", "N"))
    )
}
