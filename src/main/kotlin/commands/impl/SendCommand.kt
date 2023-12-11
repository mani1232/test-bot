package cc.worldmandia.commands.impl

import cc.worldmandia.commands.CommandImpl
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import java.awt.Color

class SendCommand(event: SlashCommandInteractionEvent) : CommandImpl(event) {
    override fun start() {
        val channel = event.getOption("channel")?.asChannel ?: event.channel
        var success = true
        if (channel is MessageChannel) channel.sendMessage(event.getOption("text")!!.asString).flatMap {
            it.channel.sendMessageEmbeds(
                EmbedBuilder().setTitle("Объявление от ${event.interaction.member?.asMention ?: "not found"}").setColor(
                    event.interaction.member?.roles?.get(0)?.color ?: Color.WHITE
                ).build()
            )
        }.queue() else success = false
        event.hook.sendMessage("Embed send: `$success`").queue()
    }
}