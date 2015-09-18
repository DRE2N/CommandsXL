package io.github.dre2n.commandsxl;

import java.io.File;

import io.github.dre2n.commandsxl.cmd.CommandsXLCMD;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandsXL extends JavaPlugin {

	private static Plugin plugin;
	private static CCommands cCommands;

	@Override
	public void onEnable() {
		plugin = this;
		File folder = new File(getDataFolder() + "/commands");
		folder.mkdir();
		setCCommands(new CCommands(this));

		getCommand("commandsxl").setExecutor(new CommandsXLCMD());

		getLogger().info("CommandsXL " + getDescription().getVersion() + " loaded succesfully!");
	}

	@Override
	public void onDisable() {
		plugin = null;
	}

	/**
	 * @return the plugin
	 */
	public static Plugin getPlugin() {
		return plugin;
	}

	/**
	 * @return the cCommands
	 */
	public static CCommands getCCommands() {
		return cCommands;
	}

	/**
	 * @param cCommands
	 * the cCommands to set
	 */
	public static void setCCommands(CCommands cCommands) {
		CommandsXL.cCommands = cCommands;
	}

}
