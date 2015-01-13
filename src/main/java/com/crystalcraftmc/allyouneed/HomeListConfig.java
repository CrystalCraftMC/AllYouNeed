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

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class HomeListConfig extends JavaPlugin{
	private FileConfiguration CustomConfig = null;
	private File customConfigFile = null;
	private Main mainfile;
	
	public HomeListConfig(){}
	
	public HomeListConfig(Main m){
		this.mainfile = m;
	}
	
	public void reloadHomeList(){//reloads (or creates) the homelist
		if(customConfigFile == null){
			
	        File pluginFolder = this.mainfile.getDataFolder();
			File fle = new File(pluginFolder,"homelist.yml");	
			try {
				fle.createNewFile();
			} catch (IOException e) {
			}
			customConfigFile = fle;
			
		}
		CustomConfig = YamlConfiguration.loadConfiguration(customConfigFile);
		
	}
	
	public FileConfiguration getHomeList(){//gets the configuration of homelist
		if(CustomConfig == null) reloadHomeList();
		return CustomConfig;
	}
	
	public void savehomelist(){
		if(CustomConfig == null || customConfigFile == null) return;
		
		try{
			getHomeList().save(customConfigFile);
		}
		catch(IOException ex){
			Bukkit.getLogger().log(Level.SEVERE, "Could not save home list");
		}
	}
}
