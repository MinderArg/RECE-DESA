package com.minder.rece.utils.tools;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tools {
	public static void deleteFile(File tempFile) {
		try {
			if (tempFile.isDirectory()) {
				File[] entries = tempFile.listFiles();
				for (File currentFile : entries) {
					deleteFile(currentFile);
				}
				tempFile.delete();
			} else {
				tempFile.delete();
			}
		} catch (Throwable t) {
		}
	}

	// Uploads a file and return its relative path.
	public static String uploadFile(String dirPath, String name, String ext, byte[] bytes)
			throws IOException {

		// Creating the directory to store file
		File dir = new File(dirPath);
		if (!dir.exists())
			dir.mkdirs();

		// Create the file on server
		File serverFile = new File(dir.getAbsolutePath() + File.separator + name + "." + ext);
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
		stream.write(bytes);
		stream.close();

		return dirPath + File.separator + name + "." + ext;
	}
}
