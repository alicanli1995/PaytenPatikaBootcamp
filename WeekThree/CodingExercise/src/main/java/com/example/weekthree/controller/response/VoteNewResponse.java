package com.example.weekthree.controller.response;

import com.example.weekthree.models.Movie;
import com.example.weekthree.models.Vote;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@Setter

public class VoteNewResponse {

    private LocalDateTime createdDate;
    private Long memberId;
    private Integer moviePoint;
    private Movie movie;

    public static VoteNewResponse convertFromVote(Vote vote){
        return VoteNewResponse.builder()
                .createdDate(vote.getCreatedDate())
                .memberId(vote.getMemberId())
                .moviePoint(vote.getMoviePoint())
                .movie(vote.getMovie())
                .build();
    }

}
