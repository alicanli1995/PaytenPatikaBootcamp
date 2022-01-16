package com.example.codingexerciseweektwo.Controller.Controller;

import com.example.codingexerciseweektwo.Controller.Class.Member;
import com.example.codingexerciseweektwo.Controller.Class.Movies;
import com.example.codingexerciseweektwo.Controller.Class.Init.InitMember;
import com.example.codingexerciseweektwo.Controller.Class.Init.InitMovies;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Scope("singleton")
@Component
@Configuration

@ApiModel(value = "All member and movies init process in this class",description = "All data creating")

public class MainInit {

    private final List<Movies> moviesList = initMovies1().getMoviesSet();
    private final List<Member> memberList = initMember1().getMemberList();

    public InitMember initMember1(){
        return new InitMember();
    }
    public InitMovies initMovies1(){
        return new InitMovies();
    }

}
