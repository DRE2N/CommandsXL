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
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

/**
 * @author Daniel Saukel
 */
public class CCommand {

    private String name;
    private File file;
    private Map<String, List<World>> commands = new HashMap<>();
    private Permission permission;

    public CCommand(String name, Map<String, List<World>> commands, Permission permission) {
        this.name = name;
        file = new File(CommandsXL.getPlugin().getDataFolder() + "/commands", name + ".yml");

        this.commands = commands;

        if (permission != null) {
            setPermission(permission);
        } else {
            setPermission(new Permission("cxl." + name));
        }
    }

    @Deprecated
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

        if (config.contains("commands")) {
            ConfigurationSection commandSection = config.getConfigurationSection("commands");
            if (commandSection != null) {
                for (Entry<String, Object> commandEntry : commandSection.getValues(false).entrySet()) {
                    List<World> worlds = new ArrayList<>();
                    for (String worldName : config.getStringList("commands." + commandEntry.getKey())) {
                        worlds.add(Bukkit.getWorld(worldName));
                    }
                    commands.put(commandEntry.getKey(), worlds);
                }
            }
        }
        if (config.contains("permission")) {
            setPermission(new Permission(config.getString("permission")));
        } else {
            setPermission(new Permission("cxl." + name));
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

    @Deprecated
    @SuppressWarnings("unchecked")
    public List<String> getCommands() {
        return (List<String>) commands.keySet();
    }

    /**
     * @return the commands
     */
    public Map<String, List<World>> getCommandMap() {
        return commands;
    }

    /**
     * @return the commands to be executed
     */
    public Set<String> getCommandsForWorld(World world) {
        Map<String, List<World>> commands = new HashMap<>(this.commands);
        for (Entry<String, List<World>> commandEntry : this.commands.entrySet()) {
            if (!commandEntry.getValue().isEmpty() || commandEntry.getValue().contains(world)) {
                commands.remove(commandEntry.getKey());
            }
        }

        return commands.keySet();
    }

    @Deprecated
    public void setCommands(List<String> commands) {
        for (String command : commands) {
            this.commands.put(command, null);
        }
    }

    /**
     * @param command
     * the command to set
     * @param world
     * the world in which the command shall be included
     */
    public void setCommand(String command, List<World> world) {
        commands.put(command, world);
    }

    /**
     * @param command
     * the command to set
     */
    public void setCommand(String command) {
        commands.put(command, null);
    }

    /**
     * @return the permission
     */
    public Permission getPermission() {
        return permission;
    }

    public Permission getPermission(CommandSender sender) {
        if (!(sender instanceof Player)) {
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
