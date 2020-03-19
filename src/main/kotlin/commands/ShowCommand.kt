package commands

import BotAdapter.Companion.jedis
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

class ShowCommand : Command{
    override val name = "show"

    override fun handle(event: GuildMessageReceivedEvent) {
        var value = ""
         value = jedis.get("Number")
        event.message.channel.sendMessage("Number is $value").queue()
        println("Show")
    }
}