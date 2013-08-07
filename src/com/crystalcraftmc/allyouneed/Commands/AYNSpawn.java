package com.crystalcraftmc.allyouneed.Commands;

import com.crystalcraftmc.allyouneed.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

<<<<<<< HEAD
import com.crystalcraftmc.allyouneed.Main;
import com.crystalcraftmc.allyouneed.TpBackListConfig;



=======
>>>>>>> ae05d78d638b069f8901a5a5454d1b7c161096b2
public class AYNSpawn implements CommandExecutor
{
	public static TpBackListConfig TpListConfig = new TpBackListConfig();
	
	Main plugin;
	
	public AYNSpawn(Main plugin)
	{
		this.plugin = plugin;
	}
	
	@Override
<<<<<<< HEAD
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		// Make the letter 'p' a variable for the command sender (or the player).
		Player p = (Player) sender;
		
	    {	
	    	// If the player typed /spawn, then do the following...
	    	if (cmd.getName().equalsIgnoreCase("spawn"))
	    	{
	    		// If the sender of the command is NOT a player...
	    		if (sender instanceof ConsoleCommandSender)
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
	    			
	    			// ...if there is no definition for spawn...
                    if (plugin.getConfig().getConfigurationSection("spawn") == null)
                    {
                    	// ...tell the player that spawn has not been set.
                    	p.sendMessage(ChatColor.RED + "The spawn has not yet been set!");
                    	return true;
                    }
                    
                    // ...if there is a definition of spawn, reference the world spawn is set in...
                    World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("spawn.world"));
                    
                    // ...reference the x-position that it is set at...
                    double x = plugin.getConfig().getDouble("spawn.x");
                    
                    // ...reference the y-position that it is set at...
                    double y = plugin.getConfig().getDouble("spawn.y");
                    
                    // ...reference the z-position that it is set at...
                    double z = plugin.getConfig().getDouble("spawn.z");
                    
                    // ...teleport the player to the referred position...
                    p.teleport(new Location(w, x, y, z));
=======
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
               
                 
>>>>>>> ae05d78d638b069f8901a5a5454d1b7c161096b2
                    
                    
                    
                   
}
