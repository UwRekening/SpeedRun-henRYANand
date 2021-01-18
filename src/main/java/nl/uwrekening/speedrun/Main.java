package nl.uwrekening.speedrun;

import nl.uwrekening.speedrun.commands.SpeedRun;
import nl.uwrekening.speedrun.commands.Test;
import nl.uwrekening.speedrun.events.*;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getCommand("speedrun").setExecutor(new SpeedRun());
        getCommand("test").setExecutor(new Test());
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getPluginManager().registerEvents(new Move(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Death(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new respawn(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Join(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Leave(), this);
    }
    @Override
    public void onDisable() {
        plugin = null;
    }

    public static Plugin getPlugin(){
        return plugin;
    }
}
