package com.example.mediaserver.dto;

import lombok.*;

import org.springframework.web.multipart.MultipartFile;

import com.example.mediaserver.model.MediaType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MediaDto {
	private Long userId;
	private String userName;
	private String url;
	private MultipartFile file;
	private MediaType mediaType;
}
