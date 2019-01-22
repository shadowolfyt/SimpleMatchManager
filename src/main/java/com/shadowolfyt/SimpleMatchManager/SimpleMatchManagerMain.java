package com.shadowolfyt.SimpleMatchManager;

import com.shadowolfyt.SimpleMatchManager.commands.stats;
import com.shadowolfyt.SimpleMatchManager.events.PlayerOnJoin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleMatchManagerMain extends JavaPlugin {
    @Override
    public void onEnable() {
        loadConfig();
        configDefaults();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\n[SMM] Simple Match Manager has been enabled.\n");

        // Events Registry
        getServer().getPluginManager().registerEvents(new PlayerOnJoin(this), this);

        // Command Registry
        //this.getCommand("stats").setExecutor((CommandExecutor)new stats(this));
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public void configDefaults() {
        this.getConfig().addDefault("players", null); // Starting players database file.
        saveConfig();
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\n[SMM] Simple Match Manager has been disabled.\n");
        loadConfig();
    }
}
