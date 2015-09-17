package io.github.dre2n.commandsxl.util;

import java.io.File;
import java.util.ArrayList;

public class FileUtil {

	public static ArrayList<File> getFilesForFolder(File folder) {
		ArrayList<File> files = new ArrayList<File>();
		for (File file : folder.listFiles()) {
			if (file.isDirectory()) {
				ArrayList<File> childFolderFiles = new ArrayList<File>();
				childFolderFiles = getFilesForFolder(file);
				files.addAll(childFolderFiles);
			} else {
				files.add(file);
			}
		}
		return files;
	}

}
