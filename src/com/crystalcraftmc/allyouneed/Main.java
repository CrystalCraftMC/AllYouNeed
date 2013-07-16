package com.crystalcraftmc.allyouneed;

import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin
{
	// When the plugin first starts...
	@Override
    public void onEnable()
	{
        // TODO Insert logic to be performed when the plugin is enabled
		getLogger().info("All You Need has been enabled!");
		
		// ...link plugin with online stats.
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e){
		    // Failed to submit the stats :-(
		}
		
		// ...generate the config.yml file.
		this.saveDefaultConfig();
		
		// ...load the configuration file and copy the defaults into the plugin...
		this.getConfig().options().copyDefaults(true);
		
		// ...and save the configuration file.
        this.saveConfig();
        
        // ...see if the config file allows auto-updating...
        if (this.getConfig().getBoolean("auto-update"))
        {
        	// ...and if so, run the auto-update class.
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
		
		// This will throw a NullPointerException if you don't have the command defined in your plugin.yml file!
		getCommand("definehome").setExecutor(new AYNDefineHome(this));
		
		// This will throw a NullPointerException if you don't have the command defined in your plugin.yml file!
		getCommand("gohome").setExecutor(new AYNGoHome(this));
    }
 
    @Override
    public void onDisable()
    {
        // TODO Insert logic to be performed when the plugin is disabled
    	getLogger().info("All You Need has been disabled!");
    }
}