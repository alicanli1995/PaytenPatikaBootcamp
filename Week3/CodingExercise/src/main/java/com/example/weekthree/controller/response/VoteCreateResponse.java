package com.example.weekthree.controller.response;


import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class VoteCreateResponse {

    private Long id;

    public static VoteCreateResponse convertToVoteResponse(Long id ){
        return VoteCreateResponse.builder()
                .id(id)
                .build();
    }
}
