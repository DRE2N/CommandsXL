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

import io.github.dre2n.commandsxl.CommandsXL;
import io.github.dre2n.commandsxl.util.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Saukel
 */
public class CCommands {

    private List<CCommand> cCommands = new ArrayList<>();

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
