package com.crystalcraftmc.allyouneed.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.crystalcraftmc.allyouneed.Main;

public class AYNRules implements CommandExecutor{
	
	Main plugin;
	public AYNRules(Main m){
		plugin = m;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		sender.sendMessage("Test... working");
		return true;
	}

}
