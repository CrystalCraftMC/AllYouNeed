package com.crystalcraftmc.allyouneed;





import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AYNSetHome  extends JavaPlugin implements CommandExecutor{
	
	Main plugin;
	public AYNSetHome(Main plugin)
	{
		this.plugin = plugin;
	}

	public HomeListConfig HomeListConfig = new HomeListConfig();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[]args)
	{
		if(label.equalsIgnoreCase("definehome"))
		{
			if(sender instanceof ConsoleCommandSender)
			{
				sender.sendMessage(ChatColor.RED + "This command can only be run by a player");
				return true;
			}
			
			else
			{
				Player p = (Player) sender;
				double X = p.getLocation().getX();
				double Y = p.getLocation().getY();
				double Z = p.getLocation().getZ();
				
				String pname = p.getName();
				HomeListConfig.getHomeList().set(pname + ".X", X);
				HomeListConfig.getHomeList().set(pname+".Y", Y);
				HomeListConfig.getHomeList().set(pname+".Z", Z);
				HomeListConfig.savehomelist();
				sender.sendMessage(ChatColor.GREEN + "Home set!");
				return true;
			}

		}
		else return false;
		
	}

}
