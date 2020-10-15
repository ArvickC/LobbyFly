package me.crazybanana4life.lobbyfly;

import me.crazybanana4life.lobbyfly.commands.Fly;
import me.crazybanana4life.lobbyfly.commands.Lfconfig;
import me.crazybanana4life.lobbyfly.commands.Lfreload;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbyFly extends JavaPlugin implements Listener {
    // Vars
    Fly fly = new Fly(this);
    Lfreload reload = new Lfreload(this);
    Lfconfig config = new Lfconfig(this);

    @Override
    public void onEnable() {
        // Plugin startup logic
        getEvents();
        getCommands();

        // Config
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        // Code
        Bukkit.getConsoleSender().sendMessage("§c[§6LobbyFly§c] §6LobbyFly§a activated successfully");
    }

    public void getCommands() {
        getCommand("fly").setExecutor(fly);
        getCommand("lfreload").setExecutor(reload);
        getCommand("lfconfig").setExecutor(config);
        Bukkit.getConsoleSender().sendMessage("§c[§6LobbyFly§c] §6Commands§a activated successfully");
    }

    public void getEvents() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(fly, this);
        Bukkit.getConsoleSender().sendMessage("§c[§6LobbyFly§c] §6Events§a activated successfully");
    }

}
