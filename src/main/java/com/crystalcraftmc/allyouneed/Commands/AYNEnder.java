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
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AYNEnder implements CommandExecutor
{
	public AYNEnder(Main main)
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
	    {	
	    	// If the player typed /ender, then do the following...
	    	if (cmd.getName().equalsIgnoreCase("ender"))
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
	    			// ...if the sender of the command is a player...
	    			Player player = (Player) sender;
	    			
	    			// ...open their ender chest.
	    			player.openInventory(player.getEnderChest());
	    		}
	    		// If this has happened, the function will return true. 
	    		return true;
	    	}
	    	
	        // If this hasn't happened, a value of false will be returned.
	    	return false;
	    }
	}
}
