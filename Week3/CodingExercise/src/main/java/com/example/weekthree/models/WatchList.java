package com.example.weekthree.models;

import com.example.weekthree.dto.MemberEntity;
import com.example.weekthree.dto.WatchlistEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@EqualsAndHashCode


public class WatchList {

    private Long memberId;
    private String watchListName;
    private LocalDateTime createdDate;
    private Long watchListId;


    public static WatchList convertFromEntity(WatchlistEntity watchlistEntity)
    {
        return WatchList.builder()
                .watchListId(watchlistEntity.getWatchListId())
                .createdDate(watchlistEntity.getCreatedDate())
                .watchListName(watchlistEntity.getWatchListName())
                .memberId(watchlistEntity.getMemberEntity().getMemberId())
                .build();
    }


    public WatchlistEntity convertToWatchList(MemberEntity memberEntity) {
        WatchlistEntity entity = new WatchlistEntity();
        entity.setWatchListId(watchListId);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setWatchListId(memberId);
        entity.setWatchListName(watchListName);
        entity.setMemberEntity(memberEntity);
        return entity;
    }



}
