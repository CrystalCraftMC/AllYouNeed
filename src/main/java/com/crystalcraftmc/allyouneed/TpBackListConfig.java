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

package com.crystalcraftmc.allyouneed;
// This file will store the location for everyone's TpBack so that they can /tpback even after a server restart

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

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
