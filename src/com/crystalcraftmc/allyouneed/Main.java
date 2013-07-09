package com.crystalcraftmc.allyouneed;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin
{
	@Override
    public void onEnable()
	{
        // TODO Insert logic to be performed when the plugin is enabled
		getLogger().info("All You Need has been enabled!");
		
		// Generate the config.yml file.
		this.saveDefaultConfig();
		
		// Load the configuration file and copy the defaults into the plugin...
		this.getConfig().options().copyDefaults(true);
		
		// ...and save the configuration file.
        this.saveConfig();
		
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
    }
 
    @Override
    public void onDisable()
    {
        // TODO Insert logic to be performed when the plugin is disabled
    	getLogger().info("All You Need has been disabled!");
    }
}