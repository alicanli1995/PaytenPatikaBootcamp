package com.example.codingexerciseweektwo.Controller.Class;

import com.example.codingexerciseweektwo.Controller.Enums.GENRE;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Movies object",description = "Movies object creating")

public class Movies {
    @ApiModelProperty(value = "Unique value for Movies Class")
    private Integer     moviesId;
    @ApiModelProperty(value = "Movies name.")
    private String      movieName;
    @ApiModelProperty(value = "Movies genre select for GENRE ENUM")
    private GENRE       movieGenre;
    @ApiModelProperty(value = "Movies release year.")
    private Integer     movieReleaseYear;
    @ApiModelProperty(value = "Movies director name.")
    private String      movieDirector;
    @ApiModelProperty(value = "Movies cast list -> String List.")
    private Set<String> movieCasts;
    @ApiModelProperty(value = "Movies point default by null.")
    private Double      moviePoint;
}
