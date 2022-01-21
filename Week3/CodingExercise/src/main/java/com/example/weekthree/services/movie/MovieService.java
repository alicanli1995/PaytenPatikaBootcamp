package com.example.weekthree.services.movie;

import com.example.weekthree.models.Actor;
import com.example.weekthree.models.Movie;

import java.util.List;

public interface MovieService {
    Long create(Movie movie, List<Actor> actors, List<Long> actorIds);

    Movie retrieve(Long id);
    void delete(Long id);
    List<Movie> getAllVoteMovies();
    List<Movie> retrieveAllV1(List<Long> getMoviesById);
}
