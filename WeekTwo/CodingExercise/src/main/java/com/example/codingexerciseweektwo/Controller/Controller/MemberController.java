package com.example.codingexerciseweektwo.Controller.Controller;


import com.example.codingexerciseweektwo.Controller.Class.Member;
import com.example.codingexerciseweektwo.Controller.Class.Movies;
import com.example.codingexerciseweektwo.Controller.Class.Watchlist;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(value="Member Controller API Documents")

public class MemberController {

    @ApiModelProperty(value = "We are editing this list.")
    private final MainInit mainInit;

    public MemberController(MainInit mainInit){
        this.mainInit = mainInit;
    }

    @PostMapping("/movies/vote/{memberId}/{moviesId}/{votingPoint}")
    @ApiOperation(value = "The method vote for Movies. Depends on memberId and moviesId")
    public List<Movies> voteMovie(@PathVariable Integer moviesId, @PathVariable Double votingPoint, @PathVariable Integer memberId){
        List<Movies> votingFilm = mainInit.getMoviesList()
                .stream()
                .filter(movies -> movies.getMoviesId().equals(moviesId))
                .collect(Collectors.toList());
        votingFilm.get(0).setMoviePoint(votingPoint);
        return mainInit.getMoviesList();
    }

    @PostMapping(path = "/watchlist/create/{memberId}/{watchListName}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "The method creating watchlist name for member")
    public Member watchlist(@PathVariable Integer memberId, @PathVariable String watchListName){
        List<Member> watchListMember = mainInit.getMemberList()
                .stream()
                .filter(member -> member.getMemberId().equals(memberId))
                .collect(Collectors.toList());
        watchListMember.get(0).setWatchListName(watchListName);
        watchListMember.get(0).setWatchlist(new Watchlist(watchListMember.get(0).getMemberId(),watchListName,1, mainInit.getMoviesList().subList(0,1)));
        return watchListMember.get(0);
    }

    @PostMapping(path = "/watchlist/add/{memberId}/{watchListId}/{moviesId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "The method adding film in watchlist depends on watchListId")
    public Watchlist addWatchList(@PathVariable Integer moviesId, @PathVariable Integer memberId,@PathVariable Integer watchListId){
        List<Member> changingMember  = mainInit.getMemberList().stream()
                .filter(member -> member.getMemberId().equals(memberId))
                .filter(member -> member.getWatchlist().getWatchListId().equals(watchListId)).collect(Collectors.toList());
        List<Movies> addingMovies    =  mainInit.getMoviesList().stream().filter(movies -> movies.getMoviesId().equals(moviesId)).collect(Collectors.toList());
        changingMember.get(0).getWatchlist().getMoviesList().addAll(addingMovies);
        return changingMember.get(0).getWatchlist();
    }

    @GetMapping("/members")
    @ApiOperation(value = "The method results all members.")
    public List<Member> getMember(){
        return mainInit.getMemberList();
    }

}
