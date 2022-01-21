package com.example.weekthree.dto.vote;


import java.util.List;

public interface VoteDto {
    Long voteToMovie(VoteEntity entity);
    List<VoteEntity> retrieveByMovieId(Long movieId);
    List<VoteEntity> getAllVoteMovies();

}
