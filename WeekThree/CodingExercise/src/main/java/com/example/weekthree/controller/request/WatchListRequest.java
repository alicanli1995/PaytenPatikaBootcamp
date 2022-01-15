package com.example.weekthree.controller.request;

import com.example.weekthree.models.WatchList;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter


public class WatchListRequest {

    @NotNull
    private Long memberId;

    @NotNull
    private String watchListName;

    public WatchList convertToWatchList(){
        return WatchList.builder()
                .memberId(memberId)
                .watchListName(watchListName)
                .build();
    }

}
