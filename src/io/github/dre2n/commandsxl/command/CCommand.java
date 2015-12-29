package io.github.dre2n.commandsxl.command;

import io.github.dre2n.commandsxl.CommandsXL;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class CCommand {
	
	private String name;
	private File file;
	private List<String> commands = new ArrayList<String>();
	private Permission permission;
	
	public CCommand(String name, ArrayList<String> commands, Permission permission) {
		this.name = name;
		file = new File(CommandsXL.getPlugin().getDataFolder() + "/commands", name + ".yml");
		
		setCommands(commands);
		
		if (permission != null) {
			setPermission(permission);
		} else {
			setPermission(new Permission("cxl." + name));
		}
	}
	
	public CCommand(File file) {
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		name = file.getName().replace(".yml", "");
		this.file = file;
		
		if (config.getStringList("commands") != null) {
			setCommands(config.getStringList("commands"));
		}
		if (config.getString("permission") != null) {
			setPermission(new Permission(config.getString("permission")));
		} else {
			setPermission(new Permission("cxl." + name));
		}
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}
	
	/**
	 * @return the commands
	 */
	public List<String> getCommands() {
		return commands;
	}
	
	/**
	 * @param commands
	 * the commands to set
	 */
	public void setCommands(List<String> commands) {
		this.commands = commands;
	}
	
	/**
	 * @return the permission
	 */
	public Permission getPermission() {
		return permission;
	}
	
	public Permission getPermission(CommandSender sender) {
		if ( !(sender instanceof Player)) {
			return new Permission(getPermission() + ".asconsole");
			
		} else if (sender.isOp()) {
			return new Permission(getPermission() + ".asop");
			
		} else {
			return permission;
		}
	}
	
	/**
	 * @param permission
	 * the permission to set
	 */
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	
}
