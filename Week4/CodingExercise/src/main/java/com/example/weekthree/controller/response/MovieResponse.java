package com.example.weekthree.controller.response;

import com.example.weekthree.models.enums.GENRE;
import com.example.weekthree.models.Movie;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@Builder


public class MovieResponse {

    private String name;
    private GENRE genre;
    private Integer releaseYear;
    private String director;


    public static MovieResponse convertFrom(Movie movie) {
        return MovieResponse.builder()
                .name(movie.getName())
                .genre(movie.getGenre())
                .releaseYear(movie.getReleaseYear())
                .director(movie.getDirector())
                .build();
    }

    public static List<MovieResponse> convertFromMovie(List<Movie> movieList) {
        return movieList.stream()
                .map(MovieResponse::convertFrom)
                .toList();
    }

}
