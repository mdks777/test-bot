package commands

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import redis.clients.jedis.Jedis

class AddCommand : Command{
    override val name = "add"

    override fun handle(event: GuildMessageReceivedEvent) {
        if (event.message.contentRaw.split(" ")[1].isNotEmpty()){
            val jedis = Jedis()
            BotAdapter.Number += event.message.contentRaw.split(" ")[1].toInt()
        }
        println("ADD")
    }
}