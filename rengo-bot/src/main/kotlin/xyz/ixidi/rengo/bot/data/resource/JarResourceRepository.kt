package xyz.ixidi.rengo.bot.data.resource

import xyz.ixidi.rengo.bot.domain.resource.ResourcesRepository
import java.io.InputStream

object JarResourceRepository : ResourcesRepository {

    override fun getResource(name: String): InputStream? = this::class.java.classLoader.getResourceAsStream(name)

}