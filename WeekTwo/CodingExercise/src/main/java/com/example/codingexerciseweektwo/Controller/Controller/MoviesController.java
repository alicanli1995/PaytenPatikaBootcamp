
package com.example.codingexerciseweektwo.Controller.Controller;

import com.example.codingexerciseweektwo.Controller.Class.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

@Configuration
@RestController
@Api(value="Movie Controller API Documents")

public class MoviesController {

    @ApiModelProperty(value = "We are editing this list.")
    private final MainInit mainInit;

    public MoviesController(MainInit mainInit){
        this.mainInit = mainInit;
    }

    @GetMapping("/movies")
    @ApiOperation(value = "List all movies list.",notes = "The methods returns Https.OK")
    @ResponseStatus(HttpStatus.OK)
    public List<Movies> listMovies(){
        return mainInit.getMoviesList();
    }


    @GetMapping("/movies/{moviesId}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "The method results depends on moviesID")
    public Movies getMovies(@PathVariable Integer moviesId){
        List<Movies> findMovies = mainInit.getMoviesList().stream().filter(movies -> movies.getMoviesId().equals(moviesId)).collect(Collectors.toList());
        return findMovies.get(0);

    }

    @PostMapping(path = "/movies/add/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "The method creating movies with Movies class body")
    public List<Movies> addMovie(@RequestBody Movies movies){
        ListIterator<Movies> listIterator = mainInit.getMoviesList().listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
        }
        listIterator.add(movies);
        return mainInit.getMoviesList();
    }

    @DeleteMapping("/movies/delete/{moviesId}")
    @ApiOperation(value = "The method deleting depends on moviesID")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovies(@PathVariable Integer moviesId){
        mainInit.getMoviesList().removeIf(vehicle -> vehicle.getMoviesId().equals(moviesId));
    }

}
