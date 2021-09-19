package xyz.ixidi.rengo.bot.di.module

import org.koin.dsl.module
import xyz.ixidi.rengo.bot.domain.language.Language
import xyz.ixidi.rengo.bot.domain.language.LanguageManager

val domainModule = module {

    single { LanguageManager(get(), Language.POLISH) }

}