package com.example.weekthree.services.vote;

import com.example.weekthree.models.Vote;

import java.util.List;

public interface VoteService {
    Long vote (Vote vote);
    List<Vote> retrieveByMovieId(Long movieId);
    List<Vote> getAllVoteMovies();
}
