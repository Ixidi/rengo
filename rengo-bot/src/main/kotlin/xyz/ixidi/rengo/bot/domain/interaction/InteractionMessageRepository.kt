package xyz.ixidi.rengo.bot.domain.interaction

interface InteractionMessageRepository {

    fun getInteractionMessage(userId: String): InteractionMessage?

}