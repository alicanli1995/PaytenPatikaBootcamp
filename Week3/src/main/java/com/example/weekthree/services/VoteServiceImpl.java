package com.example.weekthree.services;


import com.example.weekthree.dto.*;
import com.example.weekthree.models.Vote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class VoteServiceImpl implements VoteService {

    public final VoteDto voteDto;
    public final MovieDto movieDto;
    public final MemberDto memberDto;

    @Override
    public void vote(Vote vote) {
        MovieEntity movieEntity = movieDto.retrieve(vote.getMovieId());
        MemberEntity memberEntity = memberDto.retrive(vote.getMemberId());
        VoteEntity voteEntity = vote.convertToVoteEntity(movieEntity,memberEntity);
        voteDto.voteToMovie(voteEntity);
    }

    @Override
    public List<Vote> retrieveByMovieId(Long movieId) {
        return voteDto.retrieveByMovieId(movieId)
                .stream()
                .map(Vote::convertFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Vote> getAllVoteMovies() {
        return voteDto.getAllVoteMovies()
                .stream()
                .map(Vote::convertFromEntity)
                .collect(Collectors.toList());
    }


}
