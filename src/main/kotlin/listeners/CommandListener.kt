package cc.worldmandia.listeners

import cc.worldmandia.commands.impl.DefaultCommand
import cc.worldmandia.commands.impl.RollCommand
import cc.worldmandia.commands.impl.SendCommand
import cc.worldmandia.commands.impl.ThanksCommand
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import kotlin.reflect.full.primaryConstructor

class CommandListener : ListenerAdapter() {

    private val commands = mutableMapOf(
        "send" to SendCommand::class,
        "roll" to RollCommand::class,
        "thanks" to ThanksCommand::class,
    )

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        event.deferReply(true).queue()
        commands.getOrDefault(event.name, DefaultCommand::class).primaryConstructor!!.call(event).start()
    }

}