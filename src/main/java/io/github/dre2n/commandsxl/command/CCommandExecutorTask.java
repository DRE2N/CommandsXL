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
package io.github.dre2n.commandsxl.command;

import io.github.dre2n.commandsxl.util.VariableUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * @author Daniel Saukel
 */
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
        if (!player.hasPermission(cCommand.getPermission(player))) {
            player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return;
        }

        boolean isOp = player.isOp();

        if (asOp) {
            player.setOp(true);
        }

        for (String command : cCommand.getCommandsForWorld(player.getWorld())) {
            Bukkit.getServer().dispatchCommand(sender, VariableUtil.commandVariables(command, player));
        }

        if (asOp && !isOp) {
            player.setOp(false);
        }
    }

}
