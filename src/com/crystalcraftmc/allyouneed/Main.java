package com.crystalcraftmc.allyouneed;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin
{
	@Override
    public void onEnable()
	{
        // TODO Insert logic to be performed when the plugin is enabled
		getLogger().info("onEnable has been invoked!");
		
		// This will throw a NullPointerException if you don't have the command defined in your plugin.yml file!
		getCommand("ct").setExecutor(new AYNCt(this));
		
		// This will throw a NullPointerException if you don't have the command defined in your plugin.yml file!
		getCommand("ender").setExecutor(new AYNEnder(this));
    }
 
    @Override
    public void onDisable()
    {
        // TODO Insert logic to be performed when the plugin is disabled
    	getLogger().info("onDisable has been invoked!");
    }
}