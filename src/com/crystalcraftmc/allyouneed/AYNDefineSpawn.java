package com.crystalcraftmc.allyouneed;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AYNDefineSpawn implements CommandExecutor
{
	Main plugin;
	public AYNDefineSpawn(Main plugin)
	{
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		
		
	    {	
	    	// If the player typed /definespawn, then do the following...
	    	if (cmd.getName().equalsIgnoreCase("definespawn"))
	    	{
	    		if(sender instanceof Player)
	    		{
	    			// ...record the world the player is in...
	    			plugin.getConfig().set("spawn.world", sender.getLocation().getWorld().getName());
	    			
	    			// ...record the x-position the player is in...
                    plugin.getConfig().set("spawn.x", sender.getLocation().getX());
                    
                    // ...record the y-position the player is in...
                    plugin.getConfig().set("spawn.y", sender.getLocation().getY());
                    
                    // ...record the z-position the player is in...
                    plugin.getConfig().set("spawn.z", sender.getLocation().getZ());
                    
                    // ...save ALL of the above info to the config file...
                    plugin.saveConfig();
                    
                    // ...and tell the player that spawn was set successfully!
                    sender.sendMessage(ChatColor.GREEN + "Spawn set!");
	    		}
	    		// If this has happened, the function will return true. 
	    		return true;
	    	}
	    	else
	    		{
	    			
	    			sender.sendMessage("This command can only be run by a player.");
	    			return true;
	    		}
	    		
	    	
	        // If this hasn't happened, a value of false will be returned.
	    	return false;
	    }
	}
}
