package io.github.dre2n.commandsxl.listener;

import io.github.dre2n.commandsxl.CCommand;
import io.github.dre2n.commandsxl.CCommands;
import io.github.dre2n.commandsxl.CommandsXL;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandListener implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandlabel, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;

			if (args.length >= 2) {
				if ( !args[0].equalsIgnoreCase("reload")) {
					CCommand cCommand = CommandsXL.getCCommands().getCCommand(args[1]);

					// Check command
					if (cCommand != null) {

						// Console command
						if (args[0].equalsIgnoreCase("console")) {
							cCommand.execute(player, Bukkit.getServer().getConsoleSender(), false);

							// Player command; as OP
						} else if (args[0].equalsIgnoreCase("op")) {
							cCommand.execute(player, player, true);

							// Player command; default
						} else {
							cCommand.execute(player, player, false);
						}

						// Command doesn't exist
					} else {
						sender.sendMessage("I'm sorry, but this command doesn't exist.");
					}
				}

				// Wrong length
			} else {
				sender.sendMessage(ChatColor.RED + "Syntax: " + ChatColor.ITALIC + "/cxl [console|op|default] [command]");
			}
		}

		if (args.length >= 1) {
			if (args[0].equalsIgnoreCase("reload") && sender.hasPermission("cxl.reload")) {
				CommandsXL.setCCommands(new CCommands(CommandsXL.getPlugin()));
			} else {
				sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
			}
		}

		return false;
	}

}
