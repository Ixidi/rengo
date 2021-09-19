package xyz.ixidi.rengo.bot.presentation.model

import dev.kord.core.Kord
import dev.kord.core.kordLogger
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class Listeners(
    private vararg val listeners: Listener<*>
) {

    fun registerAll(kord: Kord) {
        listeners.forEach { it.register(kord) }
    }

}