package com.example.mediaserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
public class User {
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long id;

	private String userName;
	private String fullName;
	private String profilePicture;
}
