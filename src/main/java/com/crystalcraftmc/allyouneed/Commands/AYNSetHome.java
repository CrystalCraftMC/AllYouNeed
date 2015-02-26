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


import com.crystalcraftmc.allyouneed.HomeListConfig;
import com.crystalcraftmc.allyouneed.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;


public class AYNSetHome implements CommandExecutor{
	
	Main plugin;
	
	
	public AYNSetHome(Main plugin)
	{
		this.plugin = plugin;
	}
	
	public static HomeListConfig HomeListConfig = new HomeListConfig();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[]args){
		
		if(label.equalsIgnoreCase("definehome")){
			
			
			if(sender instanceof ConsoleCommandSender){
				sender.sendMessage(ChatColor.RED + "This command can only be run by a player");
				return true;
			}
			else{
				Player sder = (Player) sender;
				double X = sder.getLocation().getX();
				double Y = sder.getLocation().getY();
				double Z = sder.getLocation().getZ();
				
				String sdername = sder.getName();
				HomeListConfig.getHomeList().set(sdername + ".X", X);
				HomeListConfig.getHomeList().set(sdername+".Y", Y);
				HomeListConfig.getHomeList().set(sdername+".Z", Z);
				HomeListConfig.savehomelist();
				
				sender.sendMessage(ChatColor.GREEN + "Home set!");
				return true;
			}

		}
		else return false;
		
	}

}
