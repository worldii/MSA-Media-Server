package com.example.mediaserver.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configurable
public class AwsConfig {
	// ACCESS KEY
	// SECRET KEY
	// REGION
	@Value("${cloud.aws.credentials.access-key}")
	private String accessKey;

	@Value("${cloud.aws.credentials.secret-key}")
	private String secretKey;

	@Value("${cloud.aws.region.static}")
	private String region;

	//  function AMAZON CLIENT
	// CREDENTIAL을 통해 s3 client 를 생성해 준다.
	public AmazonS3 amazonS3Client() {
		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
		return AmazonS3ClientBuilder.standard()
			.withRegion(region)
			.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
			.build();
	}
}
