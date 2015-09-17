package io.github.dre2n.commandsxl.util;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VariableUtil {

	// Replace the standard variables
	public static String replaceVariables(String message, CommandSender sender) {
		Player player = null;

		if (sender instanceof Player) {
			player = (Player) sender;
			player.getUniqueId().toString();
		}

		// Replace symbol variables
		message.replaceAll("%play%", "\u25b6");
		message.replaceAll("%copyright%", "\u00a9");
		message.replaceAll("%registered%", "\u00ae");
		message.replaceAll("%square%", "\u00b2");
		message.replaceAll("%cubic%", "\u00b3");
		message.replaceAll("%gbp%", "\u00a3");
		message.replaceAll("%Auml%", "\u00c4");
		message.replaceAll("%Ouml%", "\u00d6");
		message.replaceAll("%Uuml%", "\u00dc");
		message.replaceAll("%auml%", "\u00e4");
		message.replaceAll("%ouml%", "\u00f6");
		message.replaceAll("%uuml%", "\u00fc");
		message.replaceAll("%Agra%", "\u00c0");
		message.replaceAll("%Aaig%", "\u00c1");
		message.replaceAll("%Acir%", "\u00c2");
		message.replaceAll("%Egra%", "\u00c8");
		message.replaceAll("%Eaig%", "\u00c9");
		message.replaceAll("%Ecir%", "\u00ca");
		message.replaceAll("%Cced%", "\u00c7");
		message.replaceAll("%Etre%", "\u00cb");
		message.replaceAll("%Itre%", "\u00cf");
		message.replaceAll("%agra%", "\u00e0");
		message.replaceAll("%aaig%", "\u00e1");
		message.replaceAll("%acir%", "\u00e2");
		message.replaceAll("%egra%", "\u00e8");
		message.replaceAll("%eaig%", "\u00e9");
		message.replaceAll("%ecir%", "\u00ea");
		message.replaceAll("%cced%", "\u00e7");
		message.replaceAll("%etre%", "\u00eb");
		message.replaceAll("%itre%", "\u00ef");
		message.replaceAll("%sz%", "\u00df");
		message.replaceAll("%ae%", "\u00e6");
		message.replaceAll("%oe%", "\u0153");
		message.replaceAll("%eur%", "\u20ac");
		message.replaceAll("%boxtop%", "\u2580");
		message.replaceAll("%boxbottom%", "\u2584");
		message.replaceAll("%boxleft%", "\u258c");
		message.replaceAll("%boxright%", "\u2590");
		message.replaceAll("%boxdot1%", "\u2591");
		message.replaceAll("%boxdot2%", "\u2592");
		message.replaceAll("%boxdot3%", "\u2593");
		message.replaceAll("%koppa%", "\u03df");
		message.replaceAll("%dei%", "\u03ee");
		message.replaceAll("%eternity%", "\u058d");
		message.replaceAll("%sajdah%", "\u06e9");
		message.replaceAll("%trademark%", "\u2122");
		message.replaceAll("%boxfull%", "\u2588");
		message.replaceAll("%squareblack%", "\u25a0");
		message.replaceAll("%squarewhite%", "\u25a1");
		message.replaceAll("%squareblacktiny%", "\u25aa");
		message.replaceAll("%squarewhitetiny%", "\u25ab");
		message.replaceAll("%left%", "\u2190");
		message.replaceAll("%up%", "\u2191");
		message.replaceAll("%right%", "\u2192");
		message.replaceAll("%down%", "\u2193");
		message.replaceAll("%leftright%", "\u2194");
		message.replaceAll("%updown%", "\u2195");
		message.replaceAll("%muuuch%", "\u221e");
		message.replaceAll("%stripe%", "\u25ac");
		message.replaceAll("%playup%", "\u25b2");
		message.replaceAll("%playright%", "\u25ba");
		message.replaceAll("%playdown%", "\u25bc");
		message.replaceAll("%playleft%", "\u25c4");
		message.replaceAll("%rhomb%", "\u25ca");
		message.replaceAll("%circle%", "\u25cb");
		message.replaceAll("%point%", "\u25cf");
		message.replaceAll("%smileywhite%", "\u263a");
		message.replaceAll("%smileyblack%", "\u263b");
		message.replaceAll("%sun%", "\u263c");
		message.replaceAll("%female%", "\u2640");
		message.replaceAll("%male%", "\u2642");
		message.replaceAll("%spade%", "\u2660");
		message.replaceAll("%clubs%", "\u2663");
		message.replaceAll("%heart%", "\u2665");
		message.replaceAll("%diamonds%", "\u2666");
		message.replaceAll("%quaver%", "\u266a");
		message.replaceAll("%2quavers%", "\u266b");

		// Replace colour codes
		message.replaceAll("&1", "\u00a71");
		message.replaceAll("&2", "\u00a72");
		message.replaceAll("&3", "\u00a73");
		message.replaceAll("&4", "\u00a74");
		message.replaceAll("&5", "\u00a75");
		message.replaceAll("&6", "\u00a76");
		message.replaceAll("&7", "\u00a77");
		message.replaceAll("&8", "\u00a78");
		message.replaceAll("&9", "\u00a79");
		message.replaceAll("&a", "\u00a7a");
		message.replaceAll("&b", "\u00a7b");
		message.replaceAll("&c", "\u00a7c");
		message.replaceAll("&d", "\u00a7d");
		message.replaceAll("&e", "\u00a7e");
		message.replaceAll("&f", "\u00a7f");
		message.replaceAll("&k", "\u00a7k");
		message.replaceAll("&l", "\u00a7l");
		message.replaceAll("&m", "\u00a7m");
		message.replaceAll("&n", "\u00a7n");
		message.replaceAll("&o", "\u00a7o");
		message.replaceAll("&r", "\u00a7r");

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

		message.replaceAll("%name%", name);
		message.replaceAll("%uuid%", uuid);
		message.replaceAll("%health%", health);
		message.replaceAll("%coords%", "X: " + x + ", Y: " + y + ". Z: " + z);

		return message;
	}

}
