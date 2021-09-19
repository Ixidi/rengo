package xyz.ixidi.rengo.bot

import dev.kord.core.Kord
import mu.KotlinLogging
import org.koin.core.component.get
import xyz.ixidi.rengo.bot.di.DependencyInjection
import xyz.ixidi.rengo.bot.presentation.model.Listeners

val rengoLogger = KotlinLogging.logger("Rengo")

class RengoException(message: String) : Exception(message)

class RengoBot {

    private var kord: Kord? = null
    private val dependencyInjection = DependencyInjection()

    suspend fun start(configuration: RengoConfiguration) {
        runCatching {
            dependencyInjection.enable()

            kord = Kord(configuration.token)
            dependencyInjection.get<Listeners>().registerAll(kord ?: return)

            kord?.login {
                rengoLogger.info{ "Bot has successfully logged in." }
                playing("works...")
            }
        }.onFailure { rengoLogger.catching(it) }
    }

    suspend fun stop() {
        kord?.shutdown()
        dependencyInjection.disable()
        kord = null
    }

}