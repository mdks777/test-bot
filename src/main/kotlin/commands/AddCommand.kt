package commands

import BotAdapter.Companion.jedis
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

class AddCommand : Command{
    override val name = "add"

    override fun handle(event: GuildMessageReceivedEvent) {
        if (event.message.contentRaw.split(" ")[1].isNotEmpty()){

            if (jedis.get("Number").isNullOrEmpty()) {
                jedis.set("Number","0")
            }
            var value = 0
            value = jedis.get("Number").toInt()
            jedis.set("Number",(value + event.message.contentRaw.split(" ")[1].toInt()).toString())

        }
        println("ADD")
    }
}