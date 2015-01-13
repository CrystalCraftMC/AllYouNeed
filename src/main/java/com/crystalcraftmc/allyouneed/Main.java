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

import com.crystalcraftmc.allyouneed.Commands.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Main extends JavaPlugin
{
	@Override
    public void onEnable()
	{
		
		//
		//
		
        // TODO Insert logic to be performed when the plugin is enabled
		getLogger().info("All You Need has been enabled!");
		
		HomeListConfig HLC = new HomeListConfig(this);
		AYNSetHome.HomeListConfig = HLC;
		AYNHome.HomeListConfig = HLC;
		
		TpBackListConfig TPLC = new TpBackListConfig(this);
		AYNTpBack.TpListConfig = TPLC;
		AYNTpgo.TpListConfig = TPLC;
		AYNHome.TpListConfig = TPLC;
		AYNSpawn.TpListConfig = TPLC;
		
		// Link plugin with online stats.
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e){
		    // Failed to submit the stats :-(
		}
		// Generate the config.yml file.
		this.saveDefaultConfig();
		
		// Load the configuration file and copy the defaults into the plugin...
		this.getConfig().options().copyDefaults(true);
		
		// ...and save the configuration file.
        this.saveConfig();
        
        // If auto-update is set to "true" in the configuration file...
        if (this.getConfig().getBoolean("auto-update"));
        {
        	// ...check for and download any new updates for the plugin.
        	@SuppressWarnings("unused")
			Updater updater = new Updater(this, "all-you-need", this.getFile(), Updater.UpdateType.DEFAULT, true);
        }
		
		// This will throw a NullPointerException if you don't have the command defined in your plugin.yml file!
		getCommand("ct").setExecutor(new AYNCt(this));
		
		// This will throw a NullPointerException if you don't have the command defined in your plugin.yml file!
		getCommand("ender").setExecutor(new AYNEnder(this));
		
		// This will throw a NullPointerException if you don't have the command defined in your plugin.yml file!
		getCommand("tpgo").setExecutor(new AYNTpgo(this));
		
		// This will throw a NullPointerException if you don't have the command defined in your plugin.yml file!
		getCommand("definespawn").setExecutor(new AYNDefineSpawn(this));
		
		// This will throw a NullPointerException if you don't have the command defined in your plugin.yml file!
		getCommand("spawn").setExecutor(new AYNSpawn(this));
		
		getCommand("definehome").setExecutor(new AYNSetHome(this));
		
		getCommand("home").setExecutor(new AYNHome(this));
		
		getCommand("heal").setExecutor(new AYNHeal(this));
		
		getCommand("tpback").setExecutor(new AYNTpBack(this));
		

	
    }
 
    @Override
    public void onDisable()
    {
        // TODO Insert logic to be performed when the plugin is disabled
    	getLogger().info("All You Need has been disabled!");
    	this.saveConfig();
    }
}