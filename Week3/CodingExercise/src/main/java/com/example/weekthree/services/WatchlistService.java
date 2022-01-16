package com.example.weekthree.services;


import com.example.weekthree.models.WatchList;

import java.util.List;
public interface WatchlistService {
    void addWatchList (WatchList watchList);
    List<WatchList> getAllVoteMovies();
}
