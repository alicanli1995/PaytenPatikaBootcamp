package com.example.weekthree.models;


import com.example.weekthree.dto.MemberEntity;
import com.example.weekthree.dto.MovieEntity;
import com.example.weekthree.dto.VoteEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Builder
@EqualsAndHashCode


public class Vote {

    private Long memberId;
    private Long movieId;
    private Integer moviePoint;
    private LocalDateTime createdDate;

    public static Vote convertFromEntity(VoteEntity voteEntity)
    {
        return Vote.builder()
                .createdDate(voteEntity.getCreatedDate())
                .memberId(voteEntity.getMemberId())
                .movieId(voteEntity.getMovie().getId())
                .moviePoint(voteEntity.getMoviePoint())
                .build();
    }
    public VoteEntity convertToVoteEntity(MovieEntity movieEntity, MemberEntity memberEntity) {
        VoteEntity entity = new VoteEntity();
        entity.setCreatedDate(LocalDateTime.now());
        entity.setMemberId(memberId);
        entity.setMovie(movieEntity);
        entity.setMember(memberEntity);
        entity.setMoviePoint(moviePoint);
        return entity;
    }



}
