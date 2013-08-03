package com.crystalcraftmc.allyouneed.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.crystalcraftmc.allyouneed.Main;

public class AYNHeal implements CommandExecutor {
	Main plugin;
	public AYNHeal(Main main){
		this.plugin = main;
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length < 1) {
            Player pl = (Player) sender;
            pl = doHeal(pl);
            return true;
        } else {
            if (plugin.getServer().getPlayer(args[0]) != null) {
                String tmp = ChatColor.translateAlternateColorCodes('&', args[0]);
                if (tmp.length() > 16) {
                    sender.sendMessage(ChatColor.RED + "Error: " + "" + ChatColor.AQUA + tmp + ChatColor.RED + " name has more than 16 characters or did not exist");)
                } else {
                    try {
                        Player pl = plugin.getServer().getPlayer(args[0]);
                    } catch (Exception e) {
                    	sender.sendMessage(ChatColor.RED + "Unknown error see logs");
                        plugin.getLogger().log(Level.SEVERE, e.getStackTrace().toString());
                        return false;
                    }

                    pl = doHeal(pl);
                    pl.sendMessage(ChatColor.GREEN + "You got healed by " + sender.getName().toString());
                }
                return true;
            }

        }

    }

    private Player doHeal(Player player){

        
        player.setHealth(player.getMaxHealth());
        player.setFoodLevel(20);
        //This should also remove poition effects to.
        player.getActivePotionEffects().clear();

        return player;
    }

}
