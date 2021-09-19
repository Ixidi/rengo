package xyz.ixidi.rengo.bot.domain.interaction

class InteractionMessage(
    val id: String,
    val state: State
) {

    enum class State {
        WELCOME
    }

}