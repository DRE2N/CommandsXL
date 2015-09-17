package io.github.dre2n.commandsxl;

import io.github.dre2n.commandsxl.util.FileUtil;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.plugin.Plugin;

public class CCommands {

	private ArrayList<CCommand> cCommands = new ArrayList<CCommand>();

	public CCommands(Plugin plugin) {
		File folder = plugin.getDataFolder();

		for (File file : FileUtil.getFilesForFolder(folder)) {
			CCommand cCommand = new CCommand(file);
			addCCommand(cCommand);
		}
	}

	/**
	 * @return all cCommands
	 */
	public ArrayList<CCommand> getCCommands() {
		return cCommands;
	}

	/**
	 * @return the cCommand
	 */
	public CCommand getCCommand(String name) {
		for (CCommand cCommand : getCCommands()) {
			if (cCommand.getName().equals(name)) {
				return cCommand;
			}
		}
		return null;
	}

	/**
	 * @param cCommands
	 * the cCommand to add
	 */
	public void addCCommand(CCommand cCommand) {
		cCommands.add(cCommand);
	}

}
