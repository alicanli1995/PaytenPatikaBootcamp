package com.example.weekthree.controller.response;
import com.example.weekthree.models.WatchList;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder

public class WatchListResponse {

    private LocalDateTime createdDate;
    private Long memberId;
    private String watchListName;
    private Long watchListId;

    public static WatchListResponse convertFromWatchList(WatchList watchList){
        return WatchListResponse.builder()
                .createdDate(watchList.getCreatedDate())
                .watchListId(watchList.getWatchListId())
                .memberId(watchList.getMemberId())
                .watchListName(watchList.getWatchListName())
                .build();
    }
    public static List<WatchListResponse> convertFromWatchList(List<WatchList> watchLists) {
        return watchLists.stream()
                .map(WatchListResponse::convertFromWatchList)
                .collect(Collectors.toList());
    }

}
