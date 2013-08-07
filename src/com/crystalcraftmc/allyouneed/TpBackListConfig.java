package com.crystalcraftmc.allyouneed;
// This file will store the location for everyone's TpBack so that they can /tpback even after a server restart
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class TpBackListConfig extends JavaPlugin
{
	private FileConfiguration CustomConfig = null;
	private File customConfigFile = null;
	private Main mainfile;
	
	public TpBackListConfig(){}
	
	public TpBackListConfig(Main m)
	{
		this.mainfile = m;
	}
	
	public void reloadTpList()//reloads (or creates) the TpBackList
	{
		if(customConfigFile == null)
		{
	        File pluginFolder = this.mainfile.getDataFolder();
			File fle = new File(pluginFolder,"tplist.yml");	
			try 
			{
				fle.createNewFile();
			}
			catch (IOException e) {}
			customConfigFile = fle;
			
		}
		CustomConfig = YamlConfiguration.loadConfiguration(customConfigFile);
		
	}
	
	public FileConfiguration getTpList()//gets the configuration of TpList
	{
		if(CustomConfig == null) reloadTpList();
		return CustomConfig;
	}
	
	public void savetplist()
	{
		if(CustomConfig == null || customConfigFile == null) return;
		
		try
		{
			getTpList().save(customConfigFile);
		}
		catch(IOException ex)
		{
			Bukkit.getLogger().log(Level.SEVERE, "Could not save home list");
		}
	}
}
