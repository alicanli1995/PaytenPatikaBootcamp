package com.example.weekthree.controller.request;

import com.example.weekthree.models.Vote;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter

public class VoteRequest {

    @NotNull
    private Long id;

    @NotNull
    private Long movieId;

    @Min(1)
    @Max(5)
    @NotNull
    private Integer moviePoint;

    public Vote convertToVote(){
        return Vote.builder()
                .memberId(id)
                .movieId(movieId)
                .moviePoint(moviePoint)
                .build();
    }

}
