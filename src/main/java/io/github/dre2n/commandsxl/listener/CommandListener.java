/*
 * Copyright (C) 2015-2016 Daniel Saukel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Daniel Saukel
 */
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

            ArrayList<String> cmdParams = new ArrayList<String>();
            if (args.length > 3) {
                cmdParams.addAll(Arrays.asList(args).subList(3, args.length));
            }

            // Console command
            if (args[0].equalsIgnoreCase("console")) {
                new CCommandExecutorTask(player, cCommand, Bukkit.getServer().getConsoleSender(), false, cmdParams).runTaskLater(plugin, (long) delay);

                // Player command; as OP
            } else if (args[0].equalsIgnoreCase("op")) {
                new CCommandExecutorTask(player, cCommand, player, true, cmdParams).runTaskLater(plugin, (long) delay);

                // Player command; default
            } else {
                new CCommandExecutorTask(player, cCommand, player, false, cmdParams).runTaskLater(plugin, (long) delay);
            }

            return true;

            // Wrong length
        } else if (args.length < 2) {
            sender.sendMessage(ChatColor.RED + "Syntax: " + ChatColor.ITALIC + "/cxl [console|op|default] [command]");
            return false;

            // Console
        } else {
            sender.sendMessage(ChatColor.RED + "This command may only be performed by a player.");
            return false;
        }

    }

}
