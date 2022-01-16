package com.example.weekthree.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class VoteDtoImpl implements VoteDto{

    private final  VoteJpaDto voteJpaDto;


    @Override
    public void voteToMovie(VoteEntity entity) {
        voteJpaDto.save(entity);
    }

    @Override
    public List<VoteEntity> retrieveByMovieId(Long movieId) {
        return voteJpaDto.retrieve(movieId);
    }

    @Override
    public List<VoteEntity> getAllVoteMovies() { return voteJpaDto.findAllByMovieId(); }
}
