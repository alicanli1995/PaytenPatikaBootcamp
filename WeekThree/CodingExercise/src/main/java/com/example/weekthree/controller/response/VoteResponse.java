package com.example.weekthree.controller.response;


import com.example.weekthree.models.Vote;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder


public class VoteResponse {

    private LocalDateTime createdDate;
    private Long id;
    private Long movieId;
    private Integer moviePoint;

    public static VoteResponse convertFromVote(Vote vote){
        return VoteResponse.builder()
                .createdDate(vote.getCreatedDate())
                .id(vote.getMemberId())
                .movieId(vote.getMovieId())
                .moviePoint(vote.getMoviePoint())
                .build();
    }
    public static List<VoteResponse> convertFromRate(List<Vote> rateList) {
        return rateList.stream()
                .map(VoteResponse::convertFromVote)
                .collect(Collectors.toList());
    }

}
