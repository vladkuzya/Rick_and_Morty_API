package com.example.dto;

import lombok.Data;

@Data
public class InfoLocationApiDto {
    private int count;
    private int pages;
    private String next;
    private String prev;
}
