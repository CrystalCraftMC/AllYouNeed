package com.crystalcraftmc.allyouneed.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.crystalcraftmc.allyouneed.Main;

public class AYNDefineSpawn implements CommandExecutor
{
	Main plugin;
	public AYNDefineSpawn(Main plugin)
	{
		this.plugin = plugin;
	}
	
 @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            System.out.println("The definespawn command must be run as a player");
        } else {
            Player p = (Player) sender;

            if (args.length <= 1 && (!cmd.getName().equalsIgnoreCase("definespawn"))) {
                Location Loc = p.getLocation();
                World world = p.getWorld();


                world.setSpawnLocation(Loc.getBlockX(), Loc.getBlockY(), Loc.getBlockZ());
                plugin.getConfig().set("spawn." + world.getName() + ".yaw", (double) getDirection(Loc.getYaw()));
                plugin.saveConfig();
                plugin.reloadConfig();
                world.save();
                p.sendMessage(ChatColor.GREEN + "You have successfully set the spawn in " + world.getName());
                return true;
            } else {
                p.sendMessage(ChatColor.DARK_RED + "You should not be providing any arguments");
                return false;
            }


            p.sendMessage(ChatColor.DARK_RED + "There was a problem setting spawn");
            plugin.getLogger().log(Level.SEVERE, "Unable to set the spawn point for " + world.getName());
            


        }

        return true;
    }

	/**
	 Works out the Yaw of the player location

	 @param yaw float
	 @return int
	 */
	public int getDirection(Float yaw)
	{
		yaw = yaw / 90;
		yaw = (float)Math.round(yaw);

		if (yaw == -4 || yaw == 0 || yaw == 4) {return 0;}
		if (yaw == -1 || yaw == 3) {return -90;}
		if (yaw == -2 || yaw == 2) {return -179;}
		if (yaw == -3 || yaw == 1) {return 90;}
		return 5;
	}
}
