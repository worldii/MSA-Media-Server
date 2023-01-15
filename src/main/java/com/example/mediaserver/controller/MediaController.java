package com.example.mediaserver.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mediaserver.dto.MediaDto;
import com.example.mediaserver.dto.MediaResponseData;
import com.example.mediaserver.dto.ResultCode;
import com.example.mediaserver.dto.ResultResponse;
import com.example.mediaserver.service.MediaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MediaController {
	private final MediaService mediaService;

	@PostMapping("/media")
	public ResponseEntity<ResultResponse> uploadMedia(MediaDto mediaDto)
	{
		MediaResponseData mediaResponseData = mediaService.save(mediaDto);
		return ResponseEntity.ok(new ResultResponse(ResultCode.MEDIA_UPLOAD_SUCCESS, mediaResponseData));
	}
}
