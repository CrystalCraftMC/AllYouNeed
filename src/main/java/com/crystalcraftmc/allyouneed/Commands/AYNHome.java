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
import com.crystalcraftmc.allyouneed.TpBackListConfig;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;


public class AYNHome implements CommandExecutor
{
	Main plugin;
	public AYNHome(Main plugin)
	{
		this.plugin = plugin;
	}
	
	public static HomeListConfig HomeListConfig = new HomeListConfig();
	public static TpBackListConfig TpListConfig = new TpBackListConfig();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[]args)
	{
		if(label.equalsIgnoreCase("home"))
		{
			if(sender instanceof ConsoleCommandSender)
			{
				sender.sendMessage(ChatColor.RED + "Only a player can execute this command");
				return true;
			}
			
			else
			{
				Player pl = (Player)sender;
				double X2 = pl.getLocation().getX();
				double Y2 = pl.getLocation().getY();
				double Z2 = pl.getLocation().getZ();
				
				String pname = pl.getName();
				TpListConfig.getTpList().set(pname + ".X", X2);
				TpListConfig.getTpList().set(pname + ".Y", Y2);
				TpListConfig.getTpList().set(pname + ".Z", Z2);
				TpListConfig.savetplist();
				
				HomeListConfig.reloadHomeList();
				double X = HomeListConfig.getHomeList().getDouble(pl.getName()+".X");
				double Y = HomeListConfig.getHomeList().getDouble(pl.getName()+".Y");
				double Z = HomeListConfig.getHomeList().getDouble(pl.getName()+".Z");
				
				World world = pl.getLocation().getWorld();			
				Location loc = new Location(world,X,Y,Z);
				loc.setWorld(world);
				loc.setX(X);
				loc.setY(Y);
				loc.setZ(Z);
				pl.teleport(loc);
				return true;
			}
		}
		else return false;
	}

}
