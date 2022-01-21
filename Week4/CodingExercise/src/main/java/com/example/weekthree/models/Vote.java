package com.example.weekthree.models;


import com.example.weekthree.dto.member.MemberEntity;
import com.example.weekthree.dto.movie.MovieEntity;
import com.example.weekthree.dto.vote.VoteEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Builder
@EqualsAndHashCode
@Setter

public class Vote {

    private Long id;
    private Long memberId;
    private Long movieId;
    private Integer moviePoint;
    private LocalDateTime createdDate;
    private Movie movie;

    public static Vote convertFromEntity(VoteEntity voteEntity)
    {
        return Vote.builder()
                .createdDate(voteEntity.getCreatedDate())
                .movie(Movie.convertFromEntity(voteEntity.getMovie()))
                .memberId(voteEntity.getMember().getMemberId())
                .movieId(voteEntity.getMovie().getId())
                .moviePoint(voteEntity.getMoviePoint())
                .build();
    }
    public VoteEntity convertToVoteEntity(MovieEntity movieEntity, MemberEntity memberEntity) {
        VoteEntity entity = new VoteEntity();
        entity.setCreatedDate(LocalDateTime.now());
        entity.setMovie(movieEntity);
        entity.setMember(memberEntity);
        entity.setMoviePoint(moviePoint);
        return entity;
    }

}
