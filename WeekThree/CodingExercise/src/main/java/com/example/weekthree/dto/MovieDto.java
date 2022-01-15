package com.example.weekthree.dto;

import java.util.List;

public interface MovieDto {

    Long saveMovie(MovieEntity movieEntity);
    MovieEntity retrieve(Long id);
    void delete(Long id);
    List<MovieEntity> getAllVoteMovies();
}
