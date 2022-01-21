package com.example.weekthree.dto.watchlist;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor


public class WatchListDtoImpl implements WatchListDto{

    private final  WatchListJpaDto watchListJpaDto;


    @Override
    public Long saveWatchList(WatchlistEntity watchList) {
        WatchlistEntity watchlistEntity = watchListJpaDto.save(watchList);
        return watchlistEntity.getWatchListId();
    }

    @Override
    public List<WatchlistEntity> getAllVoteMovies() {
        return watchListJpaDto.findAllByWatchlist();
    }

    @Override
    public WatchlistEntity retrieve(Long id) {
        Optional<WatchlistEntity> findWatchList = watchListJpaDto.findById(id);
        if (findWatchList.isPresent())
            return findWatchList.get();
        else
            throw new RuntimeException();
    }


}
