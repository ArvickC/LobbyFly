package me.crazybanana4life.lobbyfly.commands;

import me.crazybanana4life.lobbyfly.LobbyFly;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class Lfreload implements CommandExecutor {
    // Var
    private LobbyFly plugin = null;

    // Constructor
    public Lfreload(LobbyFly plugin) {
        this.plugin = plugin;
    }

    // Code
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("lobbyfly.admin")) {
            Bukkit.getServer().getPluginManager().disablePlugin(plugin);
            Bukkit.getServer().getPluginManager().enablePlugin(plugin);
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.AQUA + "[" + ChatColor.GOLD + "LobbyFly" + ChatColor.AQUA + "]" + ChatColor.GOLD + " Plugin Reloaded!");
        }
        return false;
    }
}
