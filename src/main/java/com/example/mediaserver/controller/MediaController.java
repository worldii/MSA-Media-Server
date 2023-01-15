package com.example.mediaserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mediaserver.dto.MediaDto;
import com.example.mediaserver.service.MediaService;
import com.example.mediaserver.service.S3Service;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MediaController {
	// service 지정
	private final S3Service s3Service;
	private final MediaService mediaService;

	// upload get
	@GetMapping("/api/upload")
	public String goUploadPage() {
		return "upload";
	}

	// post upload
	@PostMapping("/api/upload")
	public String UploadMedia(MediaDto mediaDto) {
		// s3 에 upload 하고
		// repository 에 저장한다.
		// 1. s3 service 만들기
		// 2. media service 만들기 ( Repository 에 저장하는)
		String url = s3Service.uploadMediaToS3(mediaDto.getFile());
		mediaDto.setUrl(url);
		mediaService.save(mediaDto);
		return "redirect:/api/hello";

	}
}
