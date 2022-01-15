package com.example.weekthree.services;

import com.example.weekthree.models.Vote;

import java.util.List;

public interface VoteService {
    void vote (Vote vote);
    List<Vote> retrieveByMovieId(Long movieId);
    List<Vote> getAllVoteMovies();
}
