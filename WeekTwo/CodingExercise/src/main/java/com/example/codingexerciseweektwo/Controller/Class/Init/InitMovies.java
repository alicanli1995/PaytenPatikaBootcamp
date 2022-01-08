package com.example.codingexerciseweektwo.Controller.Class.Init;

import com.example.codingexerciseweektwo.Controller.Class.Movies;
import com.example.codingexerciseweektwo.Controller.Enums.GENRE;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;

@Scope("singleton")
@Component


public class InitMovies {
    private final List<Movies> moviesSet = new ArrayList<>();

    public InitMovies(){
        moviesSet.add(new Movies(1,"Titanic", GENRE.DRAMA,2000,"James Cameron" , Set.of("Greg Ellis ","Brad Pitt"),0.0));
        moviesSet.add(new Movies(2,"GodFather", (GENRE.HORROR),1999,"Francis Ford Coppola" , Set.of("Nino Rota","Michael Corleone"),0.0));
        moviesSet.add(new Movies(3,"Ice Road", (GENRE.THRILLER),2005,"Jonathan Hen sleigh" , Set.of("Great heart","Evangelist"),0.0));
        moviesSet.add(new Movies(4,"Angel", (GENRE.DRAMA),2010,"Josef" , Set.of("Daniel Nelson","Memory"),0.0));
        moviesSet.add(new Movies(5,"New Blood", (GENRE.COMEDY),2009,"Elon" , Set.of("marcus thomas","Benjamin Walker"),0.0));
    }

    public List<Movies> getMoviesSet(){return moviesSet;}
}
