package com.example.dto;

import java.util.List;
import lombok.Data;

@Data
public class PersonageDto {
    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private LocationDto origin;
    private LocationDto location;
    private List<String> episode;
    private String image;
    private String url;
    private String created;
}
