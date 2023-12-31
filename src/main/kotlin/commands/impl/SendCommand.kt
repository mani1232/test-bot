package cc.worldmandia.commands.impl

import cc.worldmandia.commands.CommandImpl
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.Role.DEFAULT_COLOR_RAW
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import java.awt.Color

class SendCommand(event: SlashCommandInteractionEvent) : CommandImpl(event) {
    override fun start() {
        val channel = event.getOption("channel")?.asChannel ?: event.channel
        var success = true
        if (channel is MessageChannel) channel.sendMessage("Объявление от ${event.interaction.member?.asMention ?: "not found"}")
            .addEmbeds(
                EmbedBuilder().setTitle(event.getOption("text")!!.asString).setColor(
                    event.interaction.member?.roles?.firstOrNull { it.colorRaw != DEFAULT_COLOR_RAW }?.color ?: Color.WHITE
                ).build()
            ).queue() else success = false
        event.hook.sendMessage("Embed send: `$success`").queue()
    }
}