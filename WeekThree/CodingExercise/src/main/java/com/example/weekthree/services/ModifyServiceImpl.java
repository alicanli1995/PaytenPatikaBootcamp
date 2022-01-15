package com.example.weekthree.services;

import com.example.weekthree.dto.*;
import com.example.weekthree.models.ModifyList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor


public class ModifyServiceImpl implements ModifyService{

    private final MovieDto movieDto;
    private final WatchListDto watchListDto;
    private final ModifylistDto modifylistDto;

    @Override
    public void modifyList(ModifyList modifyList) {
        MovieEntity movieEntity = movieDto.retrieve(modifyList.getMovieId());
        WatchlistEntity watchlistEntity = watchListDto.retrieve(modifyList.getWatchListId());
        ModifyListEntity modifyListEntity = modifyList.convertToModifyEntity(movieEntity,watchlistEntity);
        modifylistDto.addToList(modifyListEntity);
    }

    @Override
    public void remove(ModifyList modifyList) {
        ModifyListEntity modifyListEntity = modifylistDto.retrieve(modifyList);
        modifylistDto.remove(modifyListEntity);
    }


}
