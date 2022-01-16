package com.example.weekthree.controller;


import com.example.weekthree.controller.request.VoteRequest;
import com.example.weekthree.controller.response.VoteNewResponse;
import com.example.weekthree.controller.response.VoteResponse;
import com.example.weekthree.services.MovieService;
import com.example.weekthree.services.MovieServiceImpl;
import com.example.weekthree.services.VoteService;
import com.example.weekthree.models.Vote;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor


public class VoteController {

    /*
        Bu api movielere point eklemek ve listelemek için yazılmıştır.
        votes path'i ile gerekli requestbodyi girerek oylama yapılabilmektedir.

        * voteMovie endpointinin çalışabilmesi için databese de kayıtlı olan bir movie id girilmelidir.

     */

    private final VoteService voteService;

    @PostMapping("/votes")
    @ResponseStatus(HttpStatus.CREATED)
    public void voteMovie(@RequestBody @Valid VoteRequest voteRequest){
        Vote vote = voteRequest.convertToVote();
        voteService.vote(vote);
    }

    @GetMapping("/votes")
    @ResponseStatus(HttpStatus.FOUND)
    public List<VoteNewResponse> retrieveByMovieId(@RequestParam Long movieId) {
        List<Vote> rateList = voteService.retrieveByMovieId(movieId);
        return rateList.stream().map(VoteNewResponse::convertFromVote).toList();
    }

    @GetMapping("/votes/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<VoteResponse> listAllVote(){
        List<Vote> voteList = voteService.getAllVoteMovies();
        return VoteResponse.convertFromRate(voteList);
    }

}
