package com.example.weekthree.services.watchlist;

import com.example.weekthree.dto.member.MemberDto;
import com.example.weekthree.dto.member.MemberEntity;
import com.example.weekthree.dto.watchlist.WatchListDto;
import com.example.weekthree.dto.watchlist.WatchlistEntity;
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
    public Long addWatchList(WatchList watchList) {
        MemberEntity memberEntity = memberDto.retrieve(watchList.getMemberId());
        WatchlistEntity watchlistEntity = watchList.convertToWatchList(memberEntity);
        return watchListDto.saveWatchList(watchlistEntity);
    }

    @Override
    public List<WatchList> getAllVoteMovies() {
        return watchListDto.getAllVoteMovies()
                .stream()
                .map(WatchList::convertFromEntity)
                .collect(Collectors.toList());
    }

}
