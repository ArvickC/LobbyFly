package me.crazybanana4life.lobbyfly.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;

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
                        ((Player) sender).setAllowFlight(true);
                    }
                }
            }
        }
        return true;
    }
}
