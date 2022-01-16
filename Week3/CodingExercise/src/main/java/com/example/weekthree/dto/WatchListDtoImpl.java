package com.example.weekthree.dto;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor


public class WatchListDtoImpl implements WatchListDto{

    private final  WatchListJpaDto watchListJpaDto;


    @Override
    public void saveWatchList(WatchlistEntity watchList) { watchListJpaDto.save(watchList); }

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
