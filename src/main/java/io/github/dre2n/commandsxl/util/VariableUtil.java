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
package io.github.dre2n.commandsxl.util;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Daniel Saukel
 */
public class VariableUtil {

    // Replace the standard variables
    public static String replaceVariables(String message, CommandSender sender) {
        Player player = null;

        if (sender instanceof Player) {
            player = (Player) sender;
            player.getUniqueId().toString();
        }

        // Replace symbol variables
        message = message.replaceAll("%play%", "\u25b6");
        message = message.replaceAll("%copyright%", "\u00a9");
        message = message.replaceAll("%registered%", "\u00ae");
        message = message.replaceAll("%square%", "\u00b2");
        message = message.replaceAll("%cubic%", "\u00b3");
        message = message.replaceAll("%gbp%", "\u00a3");
        message = message.replaceAll("%Auml%", "\u00c4");
        message = message.replaceAll("%Ouml%", "\u00d6");
        message = message.replaceAll("%Uuml%", "\u00dc");
        message = message.replaceAll("%auml%", "\u00e4");
        message = message.replaceAll("%ouml%", "\u00f6");
        message = message.replaceAll("%uuml%", "\u00fc");
        message = message.replaceAll("%Agra%", "\u00c0");
        message = message.replaceAll("%Aaig%", "\u00c1");
        message = message.replaceAll("%Acir%", "\u00c2");
        message = message.replaceAll("%Egra%", "\u00c8");
        message = message.replaceAll("%Eaig%", "\u00c9");
        message = message.replaceAll("%Ecir%", "\u00ca");
        message = message.replaceAll("%Cced%", "\u00c7");
        message = message.replaceAll("%Etre%", "\u00cb");
        message = message.replaceAll("%Itre%", "\u00cf");
        message = message.replaceAll("%agra%", "\u00e0");
        message = message.replaceAll("%aaig%", "\u00e1");
        message = message.replaceAll("%acir%", "\u00e2");
        message = message.replaceAll("%egra%", "\u00e8");
        message = message.replaceAll("%eaig%", "\u00e9");
        message = message.replaceAll("%ecir%", "\u00ea");
        message = message.replaceAll("%cced%", "\u00e7");
        message = message.replaceAll("%etre%", "\u00eb");
        message = message.replaceAll("%itre%", "\u00ef");
        message = message.replaceAll("%sz%", "\u00df");
        message = message.replaceAll("%ae%", "\u00e6");
        message = message.replaceAll("%oe%", "\u0153");
        message = message.replaceAll("%eur%", "\u20ac");
        message = message.replaceAll("%boxtop%", "\u2580");
        message = message.replaceAll("%boxbottom%", "\u2584");
        message = message.replaceAll("%boxleft%", "\u258c");
        message = message.replaceAll("%boxright%", "\u2590");
        message = message.replaceAll("%boxdot1%", "\u2591");
        message = message.replaceAll("%boxdot2%", "\u2592");
        message = message.replaceAll("%boxdot3%", "\u2593");
        message = message.replaceAll("%koppa%", "\u03df");
        message = message.replaceAll("%dei%", "\u03ee");
        message = message.replaceAll("%eternity%", "\u058d");
        message = message.replaceAll("%sajdah%", "\u06e9");
        message = message.replaceAll("%trademark%", "\u2122");
        message = message.replaceAll("%boxfull%", "\u2588");
        message = message.replaceAll("%squareblack%", "\u25a0");
        message = message.replaceAll("%squarewhite%", "\u25a1");
        message = message.replaceAll("%squareblacktiny%", "\u25aa");
        message = message.replaceAll("%squarewhitetiny%", "\u25ab");
        message = message.replaceAll("%left%", "\u2190");
        message = message.replaceAll("%up%", "\u2191");
        message = message.replaceAll("%right%", "\u2192");
        message = message.replaceAll("%down%", "\u2193");
        message = message.replaceAll("%leftright%", "\u2194");
        message = message.replaceAll("%updown%", "\u2195");
        message = message.replaceAll("%muuuch%", "\u221e");
        message = message.replaceAll("%stripe%", "\u25ac");
        message = message.replaceAll("%playup%", "\u25b2");
        message = message.replaceAll("%playright%", "\u25ba");
        message = message.replaceAll("%playdown%", "\u25bc");
        message = message.replaceAll("%playleft%", "\u25c4");
        message = message.replaceAll("%rhomb%", "\u25ca");
        message = message.replaceAll("%circle%", "\u25cb");
        message = message.replaceAll("%point%", "\u25cf");
        message = message.replaceAll("%smileywhite%", "\u263a");
        message = message.replaceAll("%smileyblack%", "\u263b");
        message = message.replaceAll("%sun%", "\u263c");
        message = message.replaceAll("%female%", "\u2640");
        message = message.replaceAll("%male%", "\u2642");
        message = message.replaceAll("%spade%", "\u2660");
        message = message.replaceAll("%clubs%", "\u2663");
        message = message.replaceAll("%heart%", "\u2665");
        message = message.replaceAll("%diamonds%", "\u2666");
        message = message.replaceAll("%quaver%", "\u266a");
        message = message.replaceAll("%2quavers%", "\u266b");

        // Replace colour codes
        message = message.replaceAll("&1", "\u00a71");
        message = message.replaceAll("&2", "\u00a72");
        message = message.replaceAll("&3", "\u00a73");
        message = message.replaceAll("&4", "\u00a74");
        message = message.replaceAll("&5", "\u00a75");
        message = message.replaceAll("&6", "\u00a76");
        message = message.replaceAll("&7", "\u00a77");
        message = message.replaceAll("&8", "\u00a78");
        message = message.replaceAll("&9", "\u00a79");
        message = message.replaceAll("&a", "\u00a7a");
        message = message.replaceAll("&b", "\u00a7b");
        message = message.replaceAll("&c", "\u00a7c");
        message = message.replaceAll("&d", "\u00a7d");
        message = message.replaceAll("&e", "\u00a7e");
        message = message.replaceAll("&f", "\u00a7f");
        message = message.replaceAll("&k", "\u00a7k");
        message = message.replaceAll("&l", "\u00a7l");
        message = message.replaceAll("&m", "\u00a7m");
        message = message.replaceAll("&n", "\u00a7n");
        message = message.replaceAll("&o", "\u00a7o");
        message = message.replaceAll("&r", "\u00a7r");

        // Replace command variables
        commandVariables(message, player);

        return message;
    }

    // Replace command variables
    public static String commandVariables(String message, CommandSender sender) {
        // Get replacement strings / numbers
        String name = "console";
        String uuid = "console";
        String health = "console";

        double x = 0;
        double y = 0;
        double z = 0;

        if (sender instanceof Player) {
            Player player = (Player) sender;

            name = player.getName();
            uuid = player.getUniqueId().toString();
            health = String.valueOf(player.getHealth());

            Location location = player.getLocation();

            x = location.getX();
            y = location.getY();
            z = location.getZ();
        }

        message = message.replaceAll("%name%", name);
        message = message.replaceAll("%uuid%", uuid);
        message = message.replaceAll("%health%", health);
        message = message.replaceAll("%coords%", "X: " + x + ", Y: " + y + ". Z: " + z);

        return message;
    }

}
