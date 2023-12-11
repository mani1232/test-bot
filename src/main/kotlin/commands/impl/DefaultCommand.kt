package cc.worldmandia.commands.impl

import cc.worldmandia.commands.CommandImpl
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent

class DefaultCommand(event: SlashCommandInteractionEvent) : CommandImpl(event) {
    override fun start() {
        event.hook.sendMessage("Command not registered")
    }
}