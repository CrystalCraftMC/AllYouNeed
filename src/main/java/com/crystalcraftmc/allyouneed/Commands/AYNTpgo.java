/*
 * Copyright 2015 Justin W. Flory
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.crystalcraftmc.allyouneed.Commands;

import com.crystalcraftmc.allyouneed.Main;
import com.crystalcraftmc.allyouneed.TpBackListConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AYNTpgo implements CommandExecutor
{
	public static TpBackListConfig TpListConfig = new TpBackListConfig();
	
	public AYNTpgo(Main main)
	{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
		// Make the letter 'p' a variable for the command sender (or the player).
		Player p = (Player) sender;
		
    	// If the player typed /tpgo, then do the following...
    	if (cmd.getName().equalsIgnoreCase("tpgo"))
    	{
    		// If the sender of the command is NOT a player...
    		if (!(sender instanceof Player))
    		{
    			// ...do not let the command be run.
    			sender.sendMessage("This command can only be run by a player.");
    		}
    		// Otherwise...
    		else
    		{
    			double X = p.getLocation().getX();
    			double Y = p.getLocation().getY();
    			double Z = p.getLocation().getZ();
    			
    			String pname = p.getName();
    			TpListConfig.getTpList().set(pname + ".X", X);
    			TpListConfig.getTpList().set(pname + ".Y", Y);
    			TpListConfig.getTpList().set(pname + ".Z", Z);
    			TpListConfig.savetplist();
    			
    			// ...if /tpgo is typed without specifying what player...
    			if (args.length == 0)
    			{
    				// ...tell the player to specify a player.
                    p.sendMessage(ChatColor.RED + "Please specify a player.");
                    return true;
    			}
    			
    		// if /tpgo is typed and a player is specified...
            Player target = Bukkit.getServer().getPlayer(args[0]);
            
            // ...and if the player isn't online...
            if (target == null)
            {
            		// ...tell the sender that the player could not be found.
                    p.sendMessage(ChatColor.RED + "Could not find player " + args[0] + "!");
                    return true;
            }
            // and if the player is online, teleport to their location!
            p.teleport(target.getLocation());
    		}
    		
    		// If this has happened, the function will return true. 
    		return true;
    	}
    	
        // If this hasn't happened, a value of false will be returned.
    	return false;
    }
}
