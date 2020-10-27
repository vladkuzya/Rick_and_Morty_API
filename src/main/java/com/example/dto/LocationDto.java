package com.example.dto;

import lombok.Data;

@Data
public class LocationDto {
    private Long id;
    private String name;
    private String type;
    private String dimension;
    private String url;
    private String created;
}
