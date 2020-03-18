package commands

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

class ShowCommand : Command{
    override val name = "show"

    override fun handle(event: GuildMessageReceivedEvent) {
        event.message.channel.sendMessage("Number is ${BotAdapter.Number}").queue()
        println("Show")
    }
}