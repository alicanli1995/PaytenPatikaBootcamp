package com.example.weekthree.controller.request;


import com.example.weekthree.models.enums.GENRE;
import com.example.weekthree.models.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter

public class MovieCreateRequest {

    @NotBlank
    private String name;

    @NotNull
    private GENRE genre;

    @NotNull
    private Integer releaseYear;

    @NotNull
    private String director;

    public Movie convertToMovie(){
        return Movie.builder()
                .name(name)
                .genre(genre)
                .releaseYear(releaseYear)
                .director(director)
                .build();
    }

}

