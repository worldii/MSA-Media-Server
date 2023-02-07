package com.example.mediaserver.dto;

import org.springframework.web.multipart.MultipartFile;

import com.example.mediaserver.model.MediaType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaDto {
    private String url;
    private MultipartFile file;
    private MediaType mediaType;
}
