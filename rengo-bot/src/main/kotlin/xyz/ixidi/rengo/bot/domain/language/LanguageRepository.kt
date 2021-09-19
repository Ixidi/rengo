package xyz.ixidi.rengo.bot.domain.language

interface LanguageRepository {

    fun getEntries(language: Language): Map<String, String>

}