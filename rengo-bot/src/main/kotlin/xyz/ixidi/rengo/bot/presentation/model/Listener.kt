package xyz.ixidi.rengo.bot.presentation.model

import dev.kord.core.Kord
import dev.kord.core.event.Event
import dev.kord.core.kordLogger
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

class Listener<E : Event>(
    private val handler: suspend E.() -> Unit,
    private val clazz: KClass<E>
) {

    fun register(kord: Kord) {
        kord.events.buffer(Channel.UNLIMITED).filter { it::class == clazz }
            .onEach {
                kord.launch { runCatching { handler(it as E) }.onFailure { kordLogger.catching(it) } }
            }
            .launchIn(kord)
    }

}

inline fun <reified E : Event> kordListener(noinline handler: suspend E.() -> Unit) = Listener(handler, E::class)