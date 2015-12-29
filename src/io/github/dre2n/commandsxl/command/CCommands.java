package io.github.dre2n.commandsxl.command;

import io.github.dre2n.commandsxl.CommandsXL;
import io.github.dre2n.commandsxl.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CCommands {
	
	private List<CCommand> cCommands = new ArrayList<CCommand>();
	
	public CCommands(CommandsXL plugin) {
		File folder = new File(plugin.getDataFolder() + "/commands");
		
		for (File file : FileUtil.getFilesForFolder(folder)) {
			CCommand cCommand = new CCommand(file);
			addCCommand(cCommand);
		}
	}
	
	/**
	 * @return all cCommands
	 */
	public List<CCommand> getCCommands() {
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
	
	/**
	 * @param cCommands
	 * the cCommand to remove
	 */
	public void removeCCommand(CCommand cCommand) {
		cCommands.remove(cCommand);
	}
	
}
