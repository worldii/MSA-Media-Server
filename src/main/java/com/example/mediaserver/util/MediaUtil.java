package com.example.mediaserver.util;

public class MediaUtil {
	// public static String findContentType(String filename) {
	// 	String ext = findExt(filename);
	// 	System.out.println(ext);
	// 	switch (ext) {
	// 		case "jpeg":case "png": case"jpg": case"gif":
	// 			return "image/"+ext;
	// 		// 비디오도 추가 함. (Refactoring 해야 함)
	// 	}
	// 	return null;
	// }

	public static String findFolder(String filename) {
		String ext = findExt(filename);
		String folder = "";
		switch (ext) {
			case "jpeg":
			case "png":
				folder = "img/";
				break;
		}
		return folder;
	}

	public static String findExt(String fileName) {
		return fileName.split("\\.")[1];
	}
}
