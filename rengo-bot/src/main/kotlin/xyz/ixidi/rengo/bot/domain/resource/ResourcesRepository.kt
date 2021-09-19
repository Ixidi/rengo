package xyz.ixidi.rengo.bot.domain.resource

import java.io.InputStream

interface ResourcesRepository {

    fun getResource(name: String): InputStream?

}