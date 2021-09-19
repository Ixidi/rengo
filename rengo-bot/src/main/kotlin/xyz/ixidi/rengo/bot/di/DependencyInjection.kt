package xyz.ixidi.rengo.bot.di

import org.koin.core.Koin
import org.koin.core.component.KoinComponent
import org.koin.dsl.koinApplication
import xyz.ixidi.rengo.bot.di.module.dataModule
import xyz.ixidi.rengo.bot.di.module.domainModule
import xyz.ixidi.rengo.bot.di.module.presentationModule

class DependencyInjection : KoinComponent {

    private var koin: Koin? = null

    fun enable() {
        if (koin != null) throw RuntimeException("Dependency injection is enabled.")

        koin = koinApplication {
            modules(domainModule, dataModule, presentationModule)
        }.koin
    }

    fun disable() {
        koin?.close()
        koin = null
    }

    override fun getKoin(): Koin = koin ?: throw RuntimeException("Dependency injection is not enabled.")

}