package com.shadowolfyt.SimpleMatchManager.commands;

import com.shadowolfyt.SimpleMatchManager.SimpleMatchManagerMain;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class stats implements CommandExecutor {
    SimpleMatchManagerMain plugin;

    public stats(SimpleMatchManagerMain instance) {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player  = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("\n");
            player.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + player.getDisplayName() + "'s Profile");
            player.sendMessage(ChatColor.AQUA.toString() + ChatColor.ITALIC + "Kills: " + ChatColor.RESET + plugin.getConfig().getInt("players" + "." + player.getPlayer().getUniqueId().toString() +  ".kills"));
            player.sendMessage(ChatColor.AQUA.toString() + ChatColor.ITALIC + "Deaths: " + ChatColor.RESET + plugin.getConfig().getInt("players" + "." + player.getPlayer().getUniqueId().toString() +  ".deaths"));
            player.sendMessage("\n");
            return true;
        }

        if (plugin.getConfig().getString("players" + "." + args[0]) == null) {
            player.sendMessage(ChatColor.RED + "That player is not in our database.");
            return true;
        } else {
            player.sendMessage("\n");
            player.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + plugin.getConfig().getString("players" + "." + args[0]) + "'s Profile");
            player.sendMessage(ChatColor.AQUA.toString() + ChatColor.ITALIC + "Kills: " + ChatColor.RESET + plugin.getConfig().getInt("players" + "." + args[0] +  ".kills"));
            player.sendMessage(ChatColor.AQUA.toString() + ChatColor.ITALIC + "Deaths: " + ChatColor.RESET + plugin.getConfig().getInt("players" + "." + args[0] +  ".deaths"));
            player.sendMessage("\n");
            return true;
        }
    }
}
