package com.example.mediaserver.model;

// DB 저장을 위한 객체 이다.

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// id
// filename
// media_url
//media_type
// username
// create_time
// media_name
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Media {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String fileName;

	@Column
	private String url;

	public Media(String fileName, String url) {
		this.fileName = fileName;
		this.url = url;
	}

	@Override
	public String toString() {
		return "FileEntity{" +
			"id=" + id +
			", fileName='" + fileName + '\'' +
			", url='" + url + '\'' +
			'}';
	}

}
