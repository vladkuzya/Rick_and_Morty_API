package com.example.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "locations")
@Data
public class Location {
    @Id
    private Long id;
    private String name;
    private String type;
    private String dimension;
    private String url;
    private String created;
}
