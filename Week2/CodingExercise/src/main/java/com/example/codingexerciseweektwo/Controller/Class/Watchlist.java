package com.example.codingexerciseweektwo.Controller.Class;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Watchlist {
    private Integer memberId;
    private String  watchListName;
    private Integer watchListId;
    private List<Movies> moviesList;
}
