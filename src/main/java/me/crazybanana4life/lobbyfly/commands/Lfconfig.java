package me.crazybanana4life.lobbyfly.commands;

import me.crazybanana4life.lobbyfly.LobbyFly;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Lfconfig implements CommandExecutor {
    // Var
    private LobbyFly plugin = null;

    // Constructor
    public Lfconfig(LobbyFly plugin) {
        this.plugin = plugin;
    }

    // Command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("lobbyfly.admin")) {
            sender.sendMessage(ChatColor.GOLD + "Your lobby world is set to: " + ChatColor.AQUA + plugin.getConfig().getString("World"));
        }

        return false;
    }
}
