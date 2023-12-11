package cc.worldmandia.commands

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent

abstract class CommandImpl(val event: SlashCommandInteractionEvent) {

    abstract fun start()

}