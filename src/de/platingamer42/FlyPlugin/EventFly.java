package de.platingamer42.FlyPlugin;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class EventFly implements Listener {
    private Main plugin;

    public EventFly(Main instance){
        plugin = instance;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent joinEvent){
        Player player = joinEvent.getPlayer();
        if(plugin.getConfig().equals(player.getName())){
            player.sendMessage("Du darfst fliegen! Nutze /fly!");
      }
    }

}
