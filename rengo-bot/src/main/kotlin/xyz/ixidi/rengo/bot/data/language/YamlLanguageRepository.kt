package xyz.ixidi.rengo.bot.data.language

import org.yaml.snakeyaml.Yaml
import xyz.ixidi.rengo.bot.RengoException
import xyz.ixidi.rengo.bot.domain.language.Language
import xyz.ixidi.rengo.bot.domain.language.LanguageRepository
import xyz.ixidi.rengo.bot.domain.resource.ResourcesRepository

class YamlLanguageRepository(
    private val resourcesRepository: ResourcesRepository
) : LanguageRepository {

    override fun getEntries(language: Language): Map<String, String> {
        val name = "lang_${language.code}.yml"
        val resource = resourcesRepository.getResource(name) ?: throw RengoException("Language resource $name is missing.")
        val entries: Map<String, Any> = Yaml().load(resource)

        return unpack("", entries)
    }

    private fun unpack(root: String, entries: Map<*, *>): Map<String, String> {
        val final = HashMap<String, String>()

        entries.forEach { (k, v) ->
            when (v) {
                is String -> final["$root$k"] = "$v"
                is Map<*, *> -> final.putAll(unpack("$root${k}.", v))
            }
        }

        return final
    }
}