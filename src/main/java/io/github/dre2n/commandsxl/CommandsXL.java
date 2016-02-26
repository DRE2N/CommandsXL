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
package io.github.dre2n.commandsxl;

import io.github.dre2n.commandsxl.command.CCommands;
import io.github.dre2n.commandsxl.listener.CommandListener;
import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Daniel Saukel
 */
public class CommandsXL extends JavaPlugin {

    private static CommandsXL plugin;
    private CCommands cCommands;

    @Override
    public void onEnable() {
        plugin = this;
        getDataFolder().mkdir();
        File folder = new File(getDataFolder() + "/commands");
        folder.mkdir();
        loadCCommands();

        getCommand("commandsxl").setExecutor(new CommandListener());

        getLogger().info("CommandsXL " + getDescription().getVersion() + " loaded succesfully!");
    }

    @Override
    public void onDisable() {
        plugin = null;
    }

    /**
     * @return the plugin instance
     */
    public static CommandsXL getPlugin() {
        return plugin;
    }

    /**
     * @return the loaded instance of CCommands
     */
    public CCommands getCCommands() {
        return cCommands;
    }

    /**
     * load / reload a new instance of CCommands
     */
    public void loadCCommands() {
        cCommands = new CCommands(this);
    }

}
