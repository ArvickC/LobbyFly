package me.crazybanana4life.lobbyfly.commands;

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

import static java.awt.Color.RED;
import static org.bukkit.ChatColor.*;

public class Fly implements CommandExecutor, Listener {
    // Var
    World lobby = Bukkit.getServer().getWorld("world");

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
                if(((Player) sender).getWorld() == lobby) {
                    // Permission Check
                    if(sender.hasPermission("lobbyfly.use")) {
                        // Code
                        if(((Player) sender).getAllowFlight() == true) {
                            sender.sendMessage(AQUA + "Flight " + GREEN + "enabled" + AQUA + "!");
                            ((Player) sender).setAllowFlight(false);
                        }
                        if(((Player) sender).getAllowFlight() == false) {
                            sender.sendMessage(AQUA + "Flight " + RED + "disabled" + AQUA + "!");
                            ((Player) sender).setAllowFlight(true);
                        }
                    } else {
                        // Permission Check
                        sender.sendMessage(RED + "You don't have " + GOLD + "permission" + RED + " to use that command!");
                    }
                } else {
                    // World Check
                    sender.sendMessage(RED + "You have to be in the " + GOLD + "lobby" + RED + " to use that command!");
                }
            } else {
                // Usage Check
                sender.sendMessage(RED + "Incorrect Usage! " + GOLD + "/fly");
            }
        } else {
            // Player Check
            sender.sendMessage(RED + "You need to be a " + GOLD + "PLAYER" + RED + " to run that command!");
        }
        return true;
    }
}
