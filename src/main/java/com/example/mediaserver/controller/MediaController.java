package com.example.mediaserver.controller;

import javax.validation.Valid;

import com.example.mediaserver.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.mediaserver.service.MediaService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MediaController {
    private final MediaService mediaService;

    @PostMapping(value = "/media",consumes = {"multipart/form-data"})
    public ResponseEntity<ResultResponse> uploadMedia(@ModelAttribute  MediaDto mediaDto) throws IOException {
        log.info("User Dto  "+mediaDto);
        log.info(mediaDto.getFile().getOriginalFilename());
        MediaResponseData mediaResponseData = mediaService.save(mediaDto);
        return ResponseEntity.ok(new ResultResponse(ResultCode.MEDIA_UPLOAD_SUCCESS, mediaResponseData));
    }
}
