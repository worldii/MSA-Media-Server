package com.example.mediaserver.model;

import javax.persistence.*;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	private String userName;
	private String fullName;
	private String profilePicture;
}
