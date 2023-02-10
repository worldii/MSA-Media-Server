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
        User tempUser = userRepository.findById(mediaDto.getUserId()).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        s3Service.uploadMediaToS3(mediaDto, tempUser.getUserName());

        Media media = Media.builder().url(mediaDto.getUrl())
                .mediaType(mediaDto.getMediaType())
                .user(tempUser).build();
        mediaRepository.save(media);

        MediaResponseData mediaResponseData = MediaResponseData.builder()
                .mediaType(media.getMediaType())
                .url(media.getUrl())
                .build();
        return mediaResponseData;
    }
}
