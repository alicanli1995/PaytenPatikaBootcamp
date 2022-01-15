package com.example.weekthree.models;

import com.example.weekthree.controller.response.CastResponse;
import com.example.weekthree.dto.MovieEntity;
import com.example.weekthree.models.enums.GENRE;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@EqualsAndHashCode

public class Movie {

    private Long id;
    private String name;
    private GENRE genre;
    private Integer releaseYear;
    private String director;
    private List<CastResponse> castList;


    public MovieEntity convertToMovieEntity(){
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setId(getId());
        movieEntity.setName(getName());
        movieEntity.setReleaseYear(this.getReleaseYear());
        movieEntity.setGenre(getGenre());
        movieEntity.setDirector(getDirector());
        return movieEntity;
    }

    public static Movie convertFromEntity(MovieEntity movieEntity)
    {
        return Movie.builder()
                .id(movieEntity.getId())
                .name(movieEntity.getName())
                .genre(movieEntity.getGenre())
                .releaseYear(movieEntity.getReleaseYear())
                .director(movieEntity.getDirector())
                .build();
    }


}
