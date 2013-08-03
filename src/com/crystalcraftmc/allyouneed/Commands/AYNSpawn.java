package com.crystalcraftmc.allyouneed.Commands;

import com.crystalcraftmc.allyouneed.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AYNSpawn implements CommandExecutor
{
	Main plugin;
	public AYNSpawn(Main plugin)
	{
		this.plugin = plugin;
	}
	
	@Override
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
