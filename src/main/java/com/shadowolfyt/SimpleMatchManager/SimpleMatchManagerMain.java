package com.shadowolfyt.SimpleMatchManager;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleMatchManagerMain extends JavaPlugin {
    @Override
    public void onEnable() {
        loadConfig();
        configDefaults();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\n[SMM] Simple Match Manager has been enabled.\n");

        // Events Registry

        // Command Registry
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public void configDefaults() {
        saveConfig();
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\n[SMM] Simple Match Manager has been disabled.\n");
        loadConfig();
    }
}
