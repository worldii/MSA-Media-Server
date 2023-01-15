package com.example.mediaserver.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.mediaserver.dto.MediaDto;
import com.example.mediaserver.model.Media;
import com.example.mediaserver.repository.MediaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MediaService {
	// Repository
	private final MediaRepository mediaRepository;

	// S3 에 오브젝트를 업로드하고 DB 에 저장해준다.
	// save
	@Transactional
	public void save(MediaDto mediaDto) {
		Media media = new Media(mediaDto.getFileName(), mediaDto.getUrl());
		mediaRepository.save(media);
	}

}
