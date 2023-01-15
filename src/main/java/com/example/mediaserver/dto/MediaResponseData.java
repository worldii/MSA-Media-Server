package com.example.mediaserver.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MediaResponseData {
	private String fileName;
	private String url;
	private MultipartFile file;
	private Long userId;
	private String userName;
}
