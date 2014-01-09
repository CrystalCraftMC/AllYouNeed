 	package com.crystalcraftmc.allyouneed.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;

import com.crystalcraftmc.allyouneed.Main;
import com.crystalcraftmc.allyouneed.TpBackListConfig;

public class AYNTpBack implements CommandExecutor
{
	public static TpBackListConfig TpListConfig = new TpBackListConfig();
	
	Main plugin;
	public AYNTpBack(Main plugin) 
	{
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("tpback"))
		{
			if (sender instanceof ConsoleCommandSender)
			{
				sender.sendMessage("This command can only be run by a player");
				return false;
			}
			
			else
			{
				Player p = (Player) sender;
				TpListConfig.reloadTpList();
				double X = TpListConfig.getTpList().getDouble(p.getName()+".X");
				double Y = TpListConfig.getTpList().getDouble(p.getName()+".Y");
				double Z = TpListConfig.getTpList().getDouble(p.getName()+".Z");
				World world = p.getLocation().getWorld();			
				Location loc1 = new Location(world,X,Y,Z);
				loc1.setWorld(world);
				loc1.setX(X);
				loc1.setY(Y);
				loc1.setZ(Z);
				p.teleport(loc1);
				return true;
			}
		}else return false;
	}
}