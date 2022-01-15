package com.example.weekthree.controller;


import com.example.weekthree.controller.request.ModifyRequest;
import com.example.weekthree.controller.request.WatchListRequest;
import com.example.weekthree.controller.response.WatchListResponse;
import com.example.weekthree.models.ModifyList;
import com.example.weekthree.models.WatchList;
import com.example.weekthree.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class WatchlistController {

    /*
        WatchlistController apisi yeni watchlist eklemeye bütük watchlistleri listelemeye
        ve oluşturulan watchlistlere movies eklemeye ve silmeyi gerçekleyen metotlar içermektedir.

        * watchlist oluşturulması için userid veritabanında kayıtlı olmalıdır.
        * watchlist'e movie eklenebilmesi için watchlistId ve Movie sistemde ki veritabanında kayıtlı olmalıdır.
        * watchlist'ten movie silebilmek için geçerli bir watchlistId ve o watchlistte var olan bir movieId
          girilmesi gerekmektedir.

     */


    private final WatchlistService watchListService;
    private final ModifyService modifyService;

    @PostMapping("/watchlist/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createWatchList(@RequestBody @Valid WatchListRequest watchListRequest){
        WatchList watchList = watchListRequest.convertToWatchList();
        watchListService.addWatchList(watchList);
    }

    @GetMapping("/watchlist")
    @ResponseStatus(HttpStatus.FOUND)
    public List<WatchListResponse> listAll(){
        List<WatchList> watchLists = watchListService.getAllVoteMovies();
        return WatchListResponse.convertFromWatchList(watchLists);
    }

    @PostMapping("/watchlist/modify/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMovies(@RequestBody @Valid ModifyRequest modifyRequest){
        ModifyList modifyList = modifyRequest.convertToModify();
        modifyService.modifyList(modifyList);
    }

    @DeleteMapping("/watchlist/modify/delete")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteMoviesOnList(@RequestBody @Valid ModifyRequest modifyRequest){
        ModifyList modifyList = modifyRequest.convertToModify();
        modifyService.remove(modifyList);
    }



}
