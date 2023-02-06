package com.example.mediaserver.service;

import java.io.IOException;

import javax.transaction.Transactional;

import com.example.mediaserver.exception.CustomException;
import com.example.mediaserver.exception.ErrorCode;
import com.example.mediaserver.util.MediaUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.mediaserver.dto.MediaDto;
import com.example.mediaserver.model.MediaType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class S3Service {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;

    @Transactional
    public void uploadMediaToS3(MediaDto mediaDto) throws IOException {
        String fileName = mediaDto.getFile().getOriginalFilename();
        log.info("FILENAME" + fileName);

        // Folder 설정해줌.
        //String folder = MediaUtil.findFolder(fileName);

//        String contentType = mediaDto.getFile().getContentType();

        String contentType = MediaUtil.findContentType(mediaDto.getFile().getContentType());
        log.info("CONTENTTYPE" + contentType);
        log.info("enum 으로 변환 " + MediaType.valueOf(contentType));

        mediaDto.setMediaType(MediaType.valueOf(contentType));

        // object 생성 및 content type 지정.
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(contentType);

        // object 의 정보를 가져 온다. 업로드한 object 를 public 에서 접근할 수 있도록 권한 부여.
        amazonS3.putObject(
                new PutObjectRequest(bucket, fileName, mediaDto.getFile().getInputStream(),
                        metadata).withCannedAcl(
                        CannedAccessControlList.PublicRead));

        mediaDto.setUrl(amazonS3.getUrl(bucket, fileName).toString());
    }
}


