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
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AYNSpawn implements CommandExecutor
{
	public static TpBackListConfig TpListConfig = new TpBackListConfig();
	
	Main plugin;
	
	public AYNSpawn(Main plugin)
	{
		this.plugin = plugin;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

		if(!(sender instanceof Player)){
			System.out.println("This command can only be run as a player");
		}
		else if (cmd.getName().equalsIgnoreCase("spawn")){
			Player p = (Player) sender;

			if(args.length > 1){
				p.sendMessage("This command does not require any arguments");
			}
			else{

				Location sp = p.getWorld().getSpawnLocation();
				sp.setYaw((float) plugin.getConfig().getDouble("spawn." + p.getWorld().getName() + ".yaw"));
				sp.setPitch((float) 0.00);
				p.teleport(sp);
				p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("spawn-message"));
			}
		}

		return true;
	}
                    
                    
                    
                   
}
