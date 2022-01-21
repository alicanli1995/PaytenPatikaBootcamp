package com.example.weekthree.models;

import com.example.weekthree.dto.movie.MovieEntity;
import com.example.weekthree.models.enums.GENRE;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode

public class Movie {

    private String name;
    private GENRE genre;
    private Integer releaseYear;
    private String director;



    public MovieEntity convertToMovieEntity(){
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(getName());
        movieEntity.setReleaseYear(getReleaseYear());
        movieEntity.setGenre(getGenre());
        movieEntity.setDirector(getDirector());
        return movieEntity;
    }

    public static Movie convertFromEntity(MovieEntity movieEntity)
    {
        return Movie.builder()
                .name(movieEntity.getName())
                .genre(movieEntity.getGenre())
                .releaseYear(movieEntity.getReleaseYear())
                .director(movieEntity.getDirector())
                .build();
    }




}
