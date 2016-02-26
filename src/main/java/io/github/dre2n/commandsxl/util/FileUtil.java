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

import java.io.File;
import java.util.ArrayList;

/**
 * @author Daniel Saukel
 */
public class FileUtil {

    public static ArrayList<File> getFilesForFolder(File folder) {
        ArrayList<File> files = new ArrayList<>();
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                ArrayList<File> childFolderFiles = new ArrayList<>();
                childFolderFiles = getFilesForFolder(file);
                files.addAll(childFolderFiles);
            } else {
                files.add(file);
            }
        }
        return files;
    }

}
