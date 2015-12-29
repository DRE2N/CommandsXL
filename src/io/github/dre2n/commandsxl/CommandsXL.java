package io.github.dre2n.commandsxl;

import java.io.File;

import io.github.dre2n.commandsxl.command.CCommands;
import io.github.dre2n.commandsxl.listener.CommandListener;

import org.bukkit.plugin.java.JavaPlugin;

public class CommandsXL extends JavaPlugin {
	
	private static CommandsXL plugin;
	private CCommands cCommands;
	
	@Override
	public void onEnable() {
		plugin = this;
		getDataFolder().mkdir();
		File folder = new File(getDataFolder() + "/commands");
		folder.mkdir();
		loadCCommands();
		
		getCommand("commandsxl").setExecutor(new CommandListener());
		
		getLogger().info("CommandsXL " + getDescription().getVersion() + " loaded succesfully!");
	}
	
	@Override
	public void onDisable() {
		plugin = null;
	}
	
	/**
	 * @return the plugin instance
	 */
	public static CommandsXL getPlugin() {
		return plugin;
	}
	
	/**
	 * @return the loaded instance of CCommands
	 */
	public CCommands getCCommands() {
		return cCommands;
	}
	
	/**
	 * load / reload a new instance of CCommands
	 */
	public void loadCCommands() {
		cCommands = new CCommands(this);
	}
	
}
