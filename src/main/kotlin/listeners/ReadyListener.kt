package cc.worldmandia.listeners

import net.dv8tion.jda.api.events.session.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.OptionData

class ReadyListener : ListenerAdapter() {

    override fun onReady(event: ReadyEvent) {
        event.jda.updateCommands().addCommands(
            Commands.slash("send", "Send embed").addOptions(
                OptionData(OptionType.STRING, "text", "Text for embed", true),
                OptionData(OptionType.CHANNEL, "channel", "Channel for send embed message", false)
            ),
            Commands.slash("roll", "Send random number")
                .addOptions(OptionData(OptionType.INTEGER, "num", "max number, 100 by default", false)),
            Commands.slash("thanks", "Send thanks for selected user")
                .addOptions(OptionData(OptionType.USER, "member", "member for thanks", true))
        )
    }
}