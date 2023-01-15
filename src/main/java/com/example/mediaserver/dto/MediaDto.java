package com.example.mediaserver.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MediaDto {

	// 업로드 된 파일을 객체로 받아주기 위해 만들어줌.
	private String fileName;
	private String url;
	private MultipartFile file;
}
