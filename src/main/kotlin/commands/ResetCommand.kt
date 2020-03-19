package commands

import BotAdapter.Companion.jedis
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

class ResetCommand : Command {
    override val name = "reset"

    override fun handle(event: GuildMessageReceivedEvent) {
        if (!jedis.get("Number").isNullOrEmpty()){
            jedis.set("Number","0")
            event.message.channel.sendMessage("I've done").queue()
        }
    }
}