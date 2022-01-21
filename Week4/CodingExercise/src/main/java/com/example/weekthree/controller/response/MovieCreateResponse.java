package com.example.weekthree.controller.response;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class MovieCreateResponse {

    private Long id;

    public static MovieCreateResponse convertToMovieResponse(Long id ){
        return MovieCreateResponse.builder()
                .id(id)
                .build();
    }

}
