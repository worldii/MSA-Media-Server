package com.example.mediaserver.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;

@Getter
public class MediaUtil {
	private  MultipartFile multiPartFile;
	private  String fileName;

	@Autowired
	public MediaUtil(MultipartFile multiPartFile){
		this.multiPartFile = multiPartFile;
		this.fileName = multiPartFile.getOriginalFilename();
	}

	public String findContentType() {
		String ext = fileName.split("\\.")[1];
		String contentType ="";
		switch (ext) {
			case "jpeg":
				contentType = "image/jpeg";
				break;
			case "png":
				contentType = "image/png";
				break;
			case "txt":
				contentType = "text/plain";
				break;
			case "csv":
				contentType = "text/csv";
				break;
		}
		return contentType;
	}

	public String findFolder() {
		String ext = fileName.split("\\.")[1];
		String folder ="";
		switch (ext) {
			case "jpeg":
				folder = "img/";
				break;
			case "png":
				folder = "img/";
				break;
			case "txt":
				folder = "txt/";
				break;
			case "csv":
				folder = "csv/";
				break;
		}
		return folder;
	}
}
