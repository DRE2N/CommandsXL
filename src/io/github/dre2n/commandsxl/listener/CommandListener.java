package io.github.dre2n.commandsxl.listener;

import io.github.dre2n.commandsxl.CommandsXL;
import io.github.dre2n.commandsxl.command.CCommand;
import io.github.dre2n.commandsxl.command.CCommandExecutorTask;
import io.github.dre2n.commandsxl.util.IntegerUtil;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandListener implements CommandExecutor {
	
	static CommandsXL plugin = CommandsXL.getPlugin();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandlabel, String[] args) {
		
		if (args.length >= 1) {
			if (args[0].equalsIgnoreCase("reload")) {
				if (sender.hasPermission("cxl.reload")) {
					plugin.loadCCommands();
					return true;
					
				} else {
					sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
					return false;
				}
			}
		}
		
		if (args.length >= 2 && sender instanceof Player) {
			Player player = (Player) sender;
			
			CCommand cCommand = plugin.getCCommands().getCCommand(args[1]);
			double delay = 0;
			
			// Check command
			if (cCommand == null) {
				sender.sendMessage(ChatColor.RED + "I'm sorry, but this command doesn't exist.");
				return false;
			}
			
			// Check delay
			if (args.length >= 3) {
				delay = IntegerUtil.parseInt(args[2]) * 20;
			}
			
			// Console command
			if (args[0].equalsIgnoreCase("console")) {
				new CCommandExecutorTask(player, cCommand, Bukkit.getServer().getConsoleSender(), false).runTaskLater(plugin, (long) delay);
				
				// Player command; as OP
			} else if (args[0].equalsIgnoreCase("op")) {
				new CCommandExecutorTask(player, cCommand, player, true).runTaskLater(plugin, (long) delay);
				
				// Player command; default
			} else {
				new CCommandExecutorTask(player, cCommand, player, false).runTaskLater(plugin, (long) delay);
			}
			
			return true;
			
			// Wrong length
		} else if (args.length < 2) {
			sender.sendMessage(ChatColor.RED + "Syntax: " + ChatColor.ITALIC + "/cxl [console|op|default] [command]");
			return false;
			
			// Console
		} else {
			sender.sendMessage(ChatColor.RED + "This command may only get performed by a player.");
			return false;
		}
		
	}
}
