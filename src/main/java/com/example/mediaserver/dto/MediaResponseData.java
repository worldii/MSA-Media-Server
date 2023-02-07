package com.example.mediaserver.dto;

import com.example.mediaserver.model.MediaType;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
public class MediaResponseData {
    private String url;
    private MediaType mediaType;
}
