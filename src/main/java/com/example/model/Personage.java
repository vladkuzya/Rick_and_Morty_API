package com.example.model;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Entity
@Table(name = "personages")
@Data
public class Personage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    @ManyToOne
    private Location origin;
    @ManyToOne
    private Location location;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="episodes_personages",
            joinColumns=@JoinColumn(name="person_id")
    )
    @Column(name="episodes_url")
    private List<String> episode;
    private String image;
    private String url;
    private String created;
}
