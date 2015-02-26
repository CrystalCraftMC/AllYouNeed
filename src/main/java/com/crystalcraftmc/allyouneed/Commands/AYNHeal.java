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
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AYNHeal implements CommandExecutor {
	Main plugin;
	Player pl;
	public AYNHeal(Main main){
		this.plugin = main;
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length < 1) {
            Player pl = (Player) sender;
            pl = doHeal(pl);
            this.pl = pl;
            return true;
        } else {
            if (plugin.getServer().getPlayer(args[0]) != null) {
                String tmp = ChatColor.translateAlternateColorCodes('&', args[0]);
                if (tmp.length() > 16) {
                    sender.sendMessage(ChatColor.RED + "Error: " + "" + ChatColor.AQUA + tmp + ChatColor.RED +
                    		" name has more than 16 characters or did not exist");
                    return true;
                } else {
                    pl = doHeal(pl);
                    pl.sendMessage(ChatColor.GREEN + "You got healed by " + sender.getName().toString());
                }
                return true;
            }else return false;

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
