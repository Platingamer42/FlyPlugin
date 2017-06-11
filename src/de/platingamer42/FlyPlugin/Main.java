package de.platingamer42.FlyPlugin;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    public void onEnable(){
        getConfig().options().copyDefaults(true);
        saveConfig();

        getCommand("fly").setExecutor(new CommandFly(this));
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new EventFly(this), this);

    }
    public void onDisable(){

    }
}


