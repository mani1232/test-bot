package cc.worldmandia.commands.impl

import cc.worldmandia.commands.CommandImpl
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import kotlin.time.Duration

class ThanksCommand(event: SlashCommandInteractionEvent) : CommandImpl(event) {

    private val usersCooldown = mutableSetOf<Long>()

    override fun start() {
        runBlocking {
            if (!usersCooldown.contains(event.interaction.user.idLong)) {
                event.hook.sendMessage(
                    "Пользователь ${event.interaction.member?.asMention ?: "Not found"} благодарит ${
                        event.getOption(
                            "member"
                        )?.asMember?.asMention ?: "Not found"
                    }"
                ).queue()
                usersCooldown.add(event.interaction.user.idLong)
                launch {
                    delay(Duration.parse("30m"))
                    usersCooldown.remove(event.interaction.user.idLong)
                }
                event.hook.sendMessage("Success!")
            } else {
                event.hook.sendMessage("Error, you need wait!")
            }
        }
    }
}