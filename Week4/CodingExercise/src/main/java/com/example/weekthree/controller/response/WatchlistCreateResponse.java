package com.example.weekthree.controller.response;


import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class WatchlistCreateResponse {

    private Long id;
    public static WatchlistCreateResponse convertToWatchlistResponse(Long id ){
        return WatchlistCreateResponse.builder()
                .id(id)
                .build();
    }
}
