package com.example.mediaserver.util;

import com.example.mediaserver.exception.CustomException;
import com.example.mediaserver.exception.ErrorCode;
import com.example.mediaserver.model.MediaType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MediaUtil {
	 public static String findContentType(String contentType) {
//	 	String ext = findExt(filename);
//	 	System.out.println(ext);
//	 	switch (ext) {
//	 		case "jpeg":case "png": case"jpg": case"gif":
//	 			return "image/"+ext;
//	 		// 비디오도 추가 함. (Refactoring 해야 함)
//	 	}
		 String[] mediaContentType = contentType.split("/");
		 if (mediaContentType.length <= 0)
			 throw new CustomException(ErrorCode.FILE_CONVERT_FAIL);
		 if (!(mediaContentType[0].toUpperCase().equals("IMAGE") || mediaContentType[0].toUpperCase().equals("VIDEO")))
			 throw  new CustomException(ErrorCode.FILE_CONVERT_FAIL);
		// log.info("media-Content-type: " + mediaContentType[0].toUpperCase());
		// log.info("enum 으로 변환 " + MediaType.valueOf(mediaContentType[0].toUpperCase()));
	 	return mediaContentType[0].toUpperCase();
	 }

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
