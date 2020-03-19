
import com.sxtanna.database.Kedis
import commands.AddCommand
import commands.Command
import commands.ResetCommand
import commands.ShowCommand
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import redis.clients.jedis.Jedis

class BotAdapter : ListenerAdapter() {

    companion object {
        val commands = mapOf<String, Command>(
            AddCommand().name to AddCommand(),
            ShowCommand().name to ShowCommand(),
            ResetCommand().name to ResetCommand()
        )
        val jedis = Jedis()
    }

    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        println("AAA")
        if (!event.message.contentRaw.startsWith(";")) return
        println("BBB")

        val input = event.message.contentRaw.substring(1).split(" ")
        val command = commands[input[0]] ?: kotlin.run{return}
        println("CCC")
        command.handle(event)
    }
}