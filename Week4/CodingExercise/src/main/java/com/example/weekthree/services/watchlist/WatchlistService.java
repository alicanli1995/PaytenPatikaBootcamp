package com.example.weekthree.services.watchlist;


import com.example.weekthree.models.WatchList;

import java.util.List;
public interface WatchlistService {
    Long addWatchList (WatchList watchList);
    List<WatchList> getAllVoteMovies();
}
