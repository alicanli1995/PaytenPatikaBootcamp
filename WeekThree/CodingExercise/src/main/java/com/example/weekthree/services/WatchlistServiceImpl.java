package com.example.weekthree.services;

import com.example.weekthree.dto.*;
import com.example.weekthree.models.WatchList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor


public class WatchlistServiceImpl implements WatchlistService{

    private final WatchListDto watchListDto;
    private final MemberDto memberDto;

    @Override
    public void addWatchList(WatchList watchList) {
        MemberEntity memberEntity = memberDto.retrive(watchList.getMemberId());
        WatchlistEntity watchlistEntity = watchList.convertToWatchList(memberEntity);
        watchListDto.saveWatchList(watchlistEntity);
    }

    @Override
    public List<WatchList> getAllVoteMovies() {
        return watchListDto.getAllVoteMovies()
                .stream()
                .map(WatchList::convertFromEntity)
                .collect(Collectors.toList());
    }

}
