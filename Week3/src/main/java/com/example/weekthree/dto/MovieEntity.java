package com.example.weekthree.dto;


import com.example.weekthree.models.enums.GENRE;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "movie")
@Table(name = "movie")

public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer releaseYear;

    @Enumerated(EnumType.STRING)
    private GENRE genre;

    @Column(nullable = false)
    private String director;


    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private List<VoteEntity> rates;

}
