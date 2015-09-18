package io.github.dre2n.commandsxl;

import io.github.dre2n.commandsxl.util.VariableUtil;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class CCommand {

	private String name;
	private File file;
	private ArrayList<String> commands;
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
			setCommands(new ArrayList<String>(config.getStringList("commands")));
		}
		if (config.getString("permission") != null) {
			setPermission(new Permission(config.getString("permission")));
		} else {
			setPermission(new Permission("cxl." + name));
		}
	}

	public void execute(Player player, CommandSender sender, boolean asOp) {
		if (player.hasPermission(getPermission(sender))) {
			boolean isOp = player.isOp();
			if (asOp) {
				player.setOp(true);
			}
			for (String command : getCommands()) {
				Bukkit.getServer().dispatchCommand(sender, VariableUtil.commandVariables(command, player));
			}
			if (asOp && !isOp) {
				player.setOp(false);
			}
		} else {
			player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
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
	public ArrayList<String> getCommands() {
		return commands;
	}

	/**
	 * @param commands
	 * the commands to set
	 */
	public void setCommands(ArrayList<String> commands) {
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
