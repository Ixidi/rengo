package xyz.ixidi.rengo.bot.presentation.listener

import dev.kord.core.event.message.MessageCreateEvent
import xyz.ixidi.rengo.bot.domain.language.Language
import xyz.ixidi.rengo.bot.domain.language.LanguageManager
import xyz.ixidi.rengo.bot.presentation.model.kordListener
import xyz.ixidi.rengo.bot.rengoLogger

fun messageCreatedListener(languageManager: LanguageManager) = kordListener<MessageCreateEvent> {
    if (this.message.author?.isBot == true) return@kordListener

    message.channel.createMessage(languageManager.getEntry(Language.POLISH, message.content))
}