package com.shadowolfyt.SimpleMatchManager.events;

import com.connorlinfoot.titleapi.TitleAPI;
import com.shadowolfyt.SimpleMatchManager.SimpleMatchManagerMain;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static org.bukkit.Bukkit.getServer;

public class PlayerOnJoin implements Listener {
    SimpleMatchManagerMain plugin;

    public PlayerOnJoin (SimpleMatchManagerMain instance) {
        plugin = instance;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        TitleAPI.sendTitle(player,40,50,40,"Welcome " + ChatColor.AQUA + player.getDisplayName(),ChatColor.GOLD + "Enjoy your stay!");

        if (!player.hasPlayedBefore()) {
            plugin.getConfig().set("players" + "." + player.getPlayer().getUniqueId().toString() + ".username", player.getDisplayName());
            plugin.getConfig().set("players" + "." + player.getPlayer().getUniqueId().toString() + ".kills", 0);
            plugin.getConfig().set("players" + "." + player.getPlayer().getUniqueId().toString() + ".deaths", 0);

            getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[SSM] " + player.getDisplayName() + " is a new player, creating their stats profile.");
            plugin.saveConfig();
        }
    }
}
