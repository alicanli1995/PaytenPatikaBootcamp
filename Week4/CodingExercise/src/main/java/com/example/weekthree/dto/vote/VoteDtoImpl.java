package com.example.weekthree.dto.vote;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class VoteDtoImpl implements VoteDto{

    private final  VoteJpaDto voteJpaDto;


    @Override
    public Long voteToMovie(VoteEntity entity) {
        VoteEntity voteEntity = voteJpaDto.save(entity);
        return voteEntity.getId();
    }

    @Override
    public List<VoteEntity> retrieveByMovieId(Long movieId) {
        return voteJpaDto.retrieve(movieId);
    }

    @Override
    public List<VoteEntity> getAllVoteMovies() { return voteJpaDto.findAllByMovieId(); }
}
