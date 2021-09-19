package xyz.ixidi.rengo.bot.domain.language

class LanguageManager(
    private val languageRepository: LanguageRepository,
    private val modelLanguage: Language
) {

    private lateinit var modelEntries: Map<String, String>
    private val allEntries = HashMap<Language, Map<String, String>>()

    fun getEntry(language: Language, key: String, vararg parameters: Pair<String, Any?>): String {
        var entries = allEntries[language]
        if (entries == null) {
            entries = loadEntries(language)
            allEntries[language] = entries
        }

        var entry = entries[key] ?: return "{$key}"
        parameters.forEach { entry = entry.replace("{${it.first}}", "${it.second}") }

        return entry
    }

    private fun loadEntries(language: Language): Map<String, String> {
        if (!::modelEntries.isInitialized) {
            modelEntries = languageRepository.getEntries(modelLanguage)
        }

        if (language == modelLanguage) return modelEntries

        val loadedEntries = languageRepository.getEntries(language)
        return modelEntries.mapValues { loadedEntries[it.key] ?: it.value }
    }

}