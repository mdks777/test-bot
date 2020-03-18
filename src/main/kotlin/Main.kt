
import net.dv8tion.jda.api.JDABuilder

val jda = JDABuilder("").addEventListeners(BotAdapter()).build().awaitReady()

fun main(){ }