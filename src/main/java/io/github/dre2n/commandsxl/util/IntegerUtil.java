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

import java.util.Random;

/**
 * @author Daniel Saukel
 */
public class IntegerUtil {

    public static int parseInt(String string) {
        int i;
        try {
            i = Integer.parseInt(string);
        } catch (NumberFormatException exception) {
            i = 0;
        }
        return i;
    }

    public static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) + min;
    }

    public static int parseInt(String string, int defaultReturn) {
        int i;
        try {
            i = Integer.parseInt(string);
        } catch (NumberFormatException exception) {
            i = defaultReturn;
        }
        return i;
    }

}
