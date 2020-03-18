import commands.AddCommand
import commands.Command
import commands.ShowCommand
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class BotAdapter : ListenerAdapter() {
    companion object {
        val prefix = ";"
        val commands = mapOf<String, Command>(
            AddCommand().name to AddCommand(),
            ShowCommand().name to ShowCommand()
        )
        var Number = 0
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