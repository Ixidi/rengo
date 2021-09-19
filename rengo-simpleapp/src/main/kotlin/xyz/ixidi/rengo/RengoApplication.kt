package xyz.ixidi.rengo

import kotlinx.coroutines.runBlocking
import xyz.ixidi.rengo.bot.RengoBot
import xyz.ixidi.rengo.bot.RengoConfiguration

fun main() = runBlocking {
    val bot = RengoBot()
    bot.start(RengoConfiguration("ODg4MTU1NDk3Mjg1NDIzMTQ0.YUOlQw.M5NE9G8O-J83eA4mckSNvhmYFFY"))
    return@runBlocking
}