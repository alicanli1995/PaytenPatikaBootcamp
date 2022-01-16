package com.example.weekthree.controller;


import com.example.weekthree.controller.request.MovieCreateRequest;
import com.example.weekthree.controller.response.MovieCreateResponse;
import com.example.weekthree.controller.response.MovieResponse;
import com.example.weekthree.models.Movie;
import com.example.weekthree.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class MovieController {

    /*
        Bu api movieleri kontrol etmek için oluşturulmuştur.

        * delete metodunun silinebilmesi için geçerli bir movie Id girilmesi gerekmektedir.
     */

    private final MovieService movieService;

    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public MovieCreateResponse createMovies(@RequestBody @Valid MovieCreateRequest movieCreateRequest){
        Movie movie = movieCreateRequest.convertToMovie();
        Long id = movieService.create(movie);
        return MovieCreateResponse.convertToMovieResponse(id);
    }

    @GetMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public MovieResponse retrieve(@PathVariable Long id) {
        Movie movie = movieService.retrieve(id);
        return MovieResponse.convertFrom(movie);
    }

    @GetMapping("/movies")
    @ResponseStatus(HttpStatus.FOUND)
    public List<MovieResponse> gelAllMovies()
    {
        List<Movie> moviesList = movieService.getAllVoteMovies();
        return MovieResponse.convertFromMovie(moviesList);
    }

    @DeleteMapping("movies/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public Long delete(@PathVariable Long id){
        movieService.delete(id);
        return id;
    }



}
