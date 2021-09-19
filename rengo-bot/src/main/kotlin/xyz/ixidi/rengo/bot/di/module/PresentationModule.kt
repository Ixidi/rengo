package xyz.ixidi.rengo.bot.di.module

import org.koin.dsl.module
import xyz.ixidi.rengo.bot.presentation.listener.messageCreatedListener
import xyz.ixidi.rengo.bot.presentation.model.Listeners

val presentationModule = module {

    single {
        Listeners(
            messageCreatedListener(get())
        )
    }


}