package com.example.weekthree.services.vote;


import com.example.weekthree.dto.member.MemberDto;
import com.example.weekthree.dto.member.MemberEntity;
import com.example.weekthree.dto.movie.MovieDto;
import com.example.weekthree.dto.movie.MovieEntity;
import com.example.weekthree.dto.vote.VoteDto;
import com.example.weekthree.dto.vote.VoteEntity;
import com.example.weekthree.models.Vote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class VoteServiceImpl implements VoteService {

    public final VoteDto voteDto;
    public final MovieDto movieDto;
    public final MemberDto memberDto;

    @Override
    public Long vote(Vote vote) {
        MovieEntity movieEntity = movieDto.retrieve(vote.getMovieId());
        MemberEntity memberEntity = memberDto.retrieve(vote.getMemberId());
        VoteEntity voteEntity = vote.convertToVoteEntity(movieEntity,memberEntity);
         return voteDto.voteToMovie(voteEntity);
    }

    @Override
    public List<Vote> retrieveByMovieId(Long movieId) {
        return voteDto.retrieveByMovieId(movieId)
                .stream()
                .map(Vote::convertFromEntity)
                .toList();
    }

    @Override
    public List<Vote> getAllVoteMovies() {
        return voteDto.getAllVoteMovies()
                .stream()
                .map(Vote::convertFromEntity)
                .toList();
    }


}
