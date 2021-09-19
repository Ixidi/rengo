package xyz.ixidi.rengo.bot.di.module

import org.koin.dsl.module
import xyz.ixidi.rengo.bot.data.language.YamlLanguageRepository
import xyz.ixidi.rengo.bot.data.resource.JarResourceRepository
import xyz.ixidi.rengo.bot.domain.language.LanguageRepository
import xyz.ixidi.rengo.bot.domain.resource.ResourcesRepository

val dataModule = module {

    single<ResourcesRepository> { JarResourceRepository }

    single<LanguageRepository> { YamlLanguageRepository(get()) }

}