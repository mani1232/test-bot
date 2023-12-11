package cc.worldmandia

import cc.worldmandia.listeners.CommandListener
import cc.worldmandia.listeners.ReadyListener
import net.dv8tion.jda.api.JDABuilder
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        JDABuilder.createDefault(args[0]).addEventListeners(CommandListener(), ReadyListener()).build()
    } else {
        exitProcess(0)
    }
}