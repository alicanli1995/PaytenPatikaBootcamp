package com.example.weekthree.dto;


import java.util.List;

public interface VoteDto {
    void voteToMovie(VoteEntity entity);
    List<VoteEntity> retrieveByMovieId(Long movieId);
    List<VoteEntity> getAllVoteMovies();

}
