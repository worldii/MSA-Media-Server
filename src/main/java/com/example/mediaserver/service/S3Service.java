package com.example.mediaserver.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.mediaserver.util.MediaUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class S3Service {

	// 변수
	// Bucket
	@Value("${cloud.aws.s3.bucket}")
	private String bucket;
	// AmazonS3
	private final AmazonS3 amazonS3;

	@Transactional
	public String uploadMediaToS3(MultipartFile multipartFile) {
		//System.out.println("BUCKET"+bucket);
		// 1.파일 형식 구하기 -> File entiity 에서 해줘야 하지 않을까?
		// -> file entity 구현하기
		MediaUtil mediaUtil = new MediaUtil(multipartFile);
		String folder = mediaUtil.findFolder();
		String contentType = mediaUtil.findContentType();
		String fileName = mediaUtil.getFileName();

		// 2. object 생성
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentType(contentType);
		try {
			amazonS3.putObject(
				new PutObjectRequest(bucket, folder + fileName, multipartFile.getInputStream(), metadata).withCannedAcl(
					CannedAccessControlList.PublicRead));
		} catch (AmazonServiceException e) {
			e.printStackTrace();
		} catch (SdkClientException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// URL 반환
		return amazonS3.getUrl(bucket, fileName).toString();

	}

	// upload File
	// 2. object 생성
	// 3. object의 content type 지정.
	// 4. 버킷에 세팅해줌.

	// 5. object 의 정보를 가져 온다. 업로드한 object 를 public 에서 접근할 수 있도록
	// 권한 부여.
	// 6. url 을 가져 온다.
	// S3 bucket 에 object 를 upload 하는 func 을 구현한다.

}


