package com.example.mediaserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mediaserver.model.Media;

@Repository

public interface MediaRepository extends JpaRepository<Media, Long> {

}
