package com.example.weekthree.dto.watchlist;

import java.util.List;

public interface WatchListDto {
    Long saveWatchList(WatchlistEntity watchList);
    List<WatchlistEntity> getAllVoteMovies();
    WatchlistEntity retrieve(Long id);

}
