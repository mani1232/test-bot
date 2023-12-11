package cc.worldmandia.commands.impl

import cc.worldmandia.commands.CommandImpl
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import kotlin.random.Random

class RollCommand(event: SlashCommandInteractionEvent) : CommandImpl(event) {
    override fun start() {
        val maxNumber = event.getOption("num")?.asInt ?: 100
        event.hook.sendMessage("Your number is: ${Random.nextInt(0, maxNumber)}")
    }
}