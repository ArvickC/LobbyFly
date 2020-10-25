package me.crazybanana4life.lobbyfly.commands;

import me.crazybanana4life.lobbyfly.LobbyFly;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import org.bukkit.ChatColor.*;
import org.bukkit.plugin.Plugin;

public class Fly implements CommandExecutor, Listener {
    // Var
    private LobbyFly plugin = null;

    // Constructor
    public Fly(LobbyFly plugin) {
        this.plugin = plugin;
    }

    // Events
    @EventHandler
    public void onPlayerJoinWorld(PlayerChangedWorldEvent event) {
        // Var
        Player player = event.getPlayer();

        // Code
        player.setAllowFlight(false);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Var
        Player player = event.getPlayer();

        // Code
        player.setAllowFlight(false);
    }

    // Command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Player Check
        if(sender instanceof Player) {
            // Command Check
            if(args.length == 0 || args == null) {
                // World Check
                if(((Player) sender).getWorld() == Bukkit.getServer().getWorld(plugin.getConfig().getString("World"))) {
                    // Permission Check
                    if(sender.hasPermission("lobbyfly.use")) {
                        // Code
                        if(((Player) sender).getAllowFlight() == true) {
                            sender.sendMessage(ChatColor.AQUA + "Flight " + ChatColor.RED + "disabled" + ChatColor.AQUA + "!");
                            ((Player) sender).setAllowFlight(false);
                            return true;
                        }
                        if(((Player) sender).getAllowFlight() == false) {
                            sender.sendMessage(ChatColor.AQUA + "Flight " + ChatColor.GREEN + "enabled" + ChatColor.AQUA + "!");
                            ((Player) sender).setAllowFlight(true);
                            return true;
                        }
                    } else {
                        // Permission Check
                        sender.sendMessage(ChatColor.RED + "You don't have " + ChatColor.GOLD + "permission" + ChatColor.RED + " to use that command!");
                    }
                } else {
                    // World Check
                    sender.sendMessage(ChatColor.RED + "You have to be in the " + ChatColor.GOLD + "lobby" + ChatColor.RED + " to use that command!");
                }
            } else {
                // Usage Check
                sender.sendMessage(ChatColor.RED + "Incorrect Usage! " + ChatColor.GOLD + "/fly");
            }
        } else {
            // Player Check
            sender.sendMessage(ChatColor.RED + "You need to be a " + ChatColor.GOLD + "PLAYER" + ChatColor.RED + " to run that command!");
        }
        return true;
    }
}
