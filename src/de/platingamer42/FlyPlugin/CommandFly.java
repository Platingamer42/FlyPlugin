package de.platingamer42.FlyPlugin;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;


public class CommandFly implements CommandExecutor {
    private Main plugin;
    CommandFly(Main instance){
        plugin = instance;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("Fly")){
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if (plugin.getConfig().getBoolean(player.getName())) {
                    if (player.getGameMode()== GameMode.SURVIVAL) {
                        if (player.getAllowFlight()) {
                            player.sendMessage("Fly wurde deaktiviert!");
                            Location loc = player.getPlayer().getLocation();

                            while (loc.getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                                loc.setY(loc.getY() - 1.25);
                            }
                            player.teleport(loc);
                            player.setAllowFlight(false);

                        } else {
                            if (!(player.getAllowFlight())) {
                                player.sendMessage("Fly wurde aktiviert!");
                                player.setAllowFlight(true);
                            }
                        }
                    }else{
                        player.sendMessage("Du bist nicht im Survial, du darfst also eh fliegen. Lass den Kack!");
                    }
                }else{
                    player.setAllowFlight(false);
                    player.sendMessage("Du darfst nicht fliegen!");
                }
            }
            else{
                if (sender instanceof ConsoleCommandSender){
                    plugin.reloadConfig();
                    System.out.println("Config neu geladen.");
                }
            }
        }
        return true;
    }
}
