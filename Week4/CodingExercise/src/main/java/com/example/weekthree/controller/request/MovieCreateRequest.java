package com.example.weekthree.controller.request;


import com.example.weekthree.models.Actor;
import com.example.weekthree.models.enums.GENRE;
import com.example.weekthree.models.Movie;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Data

public class MovieCreateRequest {

    @NotBlank
    private String name;

    @NotNull
    private GENRE genre;

    @NotNull
    private Integer releaseYear;

    @NotNull
    private String director;

    @Valid
    private List<ActorCreateRequest> actorList;

    private List<Long> actorIds;

    public Movie convertToMovie(){
        return Movie.builder()
                .name(name)
                .genre(genre)
                .releaseYear(releaseYear)
                .director(director)
                .build();
    }

    public List<Actor> convertToActors(){
        if (CollectionUtils.isEmpty(actorList))
            return new ArrayList<>();

        return actorList.stream()
                .map(ActorCreateRequest::convertToActor)
                .toList();
    }


}

