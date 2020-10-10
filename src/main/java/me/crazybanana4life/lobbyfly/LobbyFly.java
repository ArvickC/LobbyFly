package me.crazybanana4life.lobbyfly;

import me.crazybanana4life.lobbyfly.commands.Fly;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyFly extends JavaPlugin implements Listener {
    // Vars
    Fly fly = new Fly();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(fly, this);

        getCommand("fly").setExecutor(fly);
    }
}
