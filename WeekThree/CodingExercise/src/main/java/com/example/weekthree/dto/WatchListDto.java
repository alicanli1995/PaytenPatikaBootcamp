package com.example.weekthree.dto;

import java.util.List;

public interface WatchListDto {
    void saveWatchList(WatchlistEntity watchList);
    List<WatchlistEntity> getAllVoteMovies();
    WatchlistEntity retrieve(Long id);

}
