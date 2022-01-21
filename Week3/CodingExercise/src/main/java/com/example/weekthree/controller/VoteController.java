package com.example.weekthree.controller;


import com.example.weekthree.controller.request.VoteRequest;
import com.example.weekthree.controller.response.VoteCreateResponse;
import com.example.weekthree.controller.response.VoteResponse;
import com.example.weekthree.models.Vote;
import com.example.weekthree.services.vote.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public VoteCreateResponse voteMovie(@RequestBody @Valid VoteRequest voteRequest){
        Vote vote = voteRequest.convertToVote();
        Long returnId = voteService.vote(vote);
        return VoteCreateResponse.convertToVoteResponse(returnId);
    }

    @GetMapping("/votes")
    @ResponseStatus(HttpStatus.FOUND)
    public List<VoteResponse> retrieveByMovieId(@RequestParam Long movieId) {
        List<Vote> rateList = voteService.retrieveByMovieId(movieId);
        return rateList.stream().map(VoteResponse::convertFromVote).toList();
    }

    @GetMapping("/votes/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<VoteResponse> listAllVote(){
        List<Vote> voteList = voteService.getAllVoteMovies();
        return VoteResponse.convertFromRate(voteList);
    }


}
