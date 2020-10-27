package com.example.dto;

import java.util.List;
import lombok.Data;

@Data
public class PersonageApiDto {
    private InfoPersonageApiDto info;
    private List<PersonageDto> results;
}
