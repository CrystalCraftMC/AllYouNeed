package com.crystalcraftmc.allyouneed.Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.crystalcraftmc.allyouneed.Main;

public class Spawn implements CommandExecutor
{
	private Main pl;
	public void Spawn(Main mn)
	{
		pl = mn;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(!(sender instanceof Player))
		{
			System.out.println("This command can only be run by a player.");
			
		}
		else
		{
			Player p = (Player) sender;
			
			if(args.length > 1)
			{
				p.sendMessage("No arguments needed for this command.");
				
			}else
			{
				Location loc = p.getWorld().getSpawnLocation();
				loc.setPitch((float)pl.getConfig().getDouble("spawn.pitch"));
				l
			}
		}
		
		return true;
	}

}
