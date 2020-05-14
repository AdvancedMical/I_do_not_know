package idonotknow

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.plugin.java.JavaPlugin

class I_do_not_know: JavaPlugin(), Listener {

    override fun onEnable() {
        server.pluginManager.registerEvents(this, this);
        saveDefaultConfig()
        logger.info("\u00a7aI_do_not_know插件v${description.version}已经启动!")
    }

    override fun onDisable() {
        logger.info("\u00a7cI_do_not_know插件v${description.version}已经停止!")
    }

    @EventHandler
    fun onChat(event: AsyncPlayerChatEvent) {
        val message: String = event.message
        if (message.contains("怎么") || message.contains("为什么")) {
            server.scheduler.runTask(this) { ->
                config.getString("msg")?.replace("&", "\u00a7")?.let { Bukkit.broadcastMessage(it) }
            }
            server.scheduler.runTask(this) {->

            }
        }
    }
}