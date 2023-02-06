package com.example.mediaserver.service;

import javax.transaction.Transactional;

import com.example.mediaserver.exception.CustomException;
import com.example.mediaserver.exception.ErrorCode;
import org.springframework.stereotype.Service;

import com.example.mediaserver.dto.MediaDto;
import com.example.mediaserver.dto.MediaResponseData;
import com.example.mediaserver.model.Media;
import com.example.mediaserver.model.User;
import com.example.mediaserver.repository.MediaRepository;
import com.example.mediaserver.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class MediaService {
	private final MediaRepository mediaRepository;
	private final S3Service s3Service;
	private final UserRepository userRepository;

	@Transactional
	public MediaResponseData save(MediaDto mediaDto) throws IOException {

		//Upload 하는 유저 찾아냄(from User Service)
//		//NOT IMPLEMENT // REFACTORING
		User tempUser = new User();
		tempUser.setId(1L);
		tempUser.setUserName("Jongha");
		tempUser.setFullName("park");
		userRepository.save(tempUser);


		s3Service.uploadMediaToS3(mediaDto);

//		// Media 레포지토리에 생성.
		Media media = Media.builder().url(mediaDto.getUrl())
			.mediaType(mediaDto.getMediaType())
			.user(tempUser).build();
		mediaRepository.save(media);
//
//		// Media Response API 생성.
		MediaResponseData mediaResponseData = MediaResponseData.builder()
			.mediaType(media.getMediaType())
			.url(media.getUrl())
			.build();
		return mediaResponseData;
	}
}
