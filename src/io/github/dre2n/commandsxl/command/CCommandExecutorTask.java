package io.github.dre2n.commandsxl.command;

import io.github.dre2n.commandsxl.util.VariableUtil;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CCommandExecutorTask extends BukkitRunnable {
	
	private Player player;
	private CCommand cCommand;
	private CommandSender sender;
	private boolean asOp;
	
	public CCommandExecutorTask(Player player, CCommand cCommand, CommandSender sender, boolean asOp) {
		this.player = player;
		this.cCommand = cCommand;
		this.sender = sender;
		this.asOp = asOp;
	}
	
	@Override
	public void run() {
		if ( !player.hasPermission(cCommand.getPermission(player))) {
			player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
			return;
		}
		
		boolean isOp = player.isOp();
		
		if (asOp) {
			player.setOp(true);
		}
		
		for (String command : cCommand.getCommands()) {
			Bukkit.getServer().dispatchCommand(sender, VariableUtil.commandVariables(command, player));
		}
		
		if (asOp && !isOp) {
			player.setOp(false);
		}
	}
	
}
