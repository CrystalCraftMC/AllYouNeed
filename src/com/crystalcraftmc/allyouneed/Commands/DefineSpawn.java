package com.crystalcraftmc.allyouneed.Commands;

import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.crystalcraftmc.allyouneed.Main;

public class DefineSpawn implements CommandExecutor
{
	
	private Main plugin;

	public void SetSpawn(Main mn)
	{
		plugin = mn;
	}
	
	public DefineSpawn(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (!(sender instanceof Player))
		{
			System.out.println("This command can only be run by a player.");
			return false;
		}
		
		Player p = (Player) sender;
		
		Location loc = p.getLocation();
    	World world = p.getWorld();
		
	    if (cmd.getName().equalsIgnoreCase("definespawn"))
	    {	
	    	world.setSpawnLocation(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
	    	plugin.getConfig().set("spawn.yaw", loc.getYaw());
	    	plugin.getConfig().set("spawn.pitch", loc.getPitch());
	    	plugin.saveConfig();
	    	plugin.reloadConfig();
	    	p.sendMessage(ChatColor.GREEN + "Spawn set!");
	    }
	    	else
	    	{
	    		p.sendMessage("There was a problem setting the spawn");
	    		plugin.getLogger().log(Level.SEVERE,"Unable to set the spawn for the world.");
	    	}
	    	
	    	return true;
	}
}