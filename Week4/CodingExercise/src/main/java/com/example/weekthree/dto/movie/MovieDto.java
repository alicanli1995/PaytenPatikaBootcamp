package com.example.weekthree.dto.movie;

import java.util.List;

public interface MovieDto {

    MovieEntity saveMovie(MovieEntity movieEntity);
    MovieEntity retrieve(Long id);
    void delete(Long id);
    List<MovieEntity> getAllVoteMovies();

    List<MovieEntity> retrieveAll(List<Long> getMoviesById);
}
