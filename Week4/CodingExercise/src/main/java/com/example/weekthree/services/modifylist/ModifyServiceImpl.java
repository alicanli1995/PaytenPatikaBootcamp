package com.example.weekthree.services.modifylist;

import com.example.weekthree.dto.modifylist.ModifyListEntity;
import com.example.weekthree.dto.modifylist.ModifylistDto;
import com.example.weekthree.dto.movie.MovieDto;
import com.example.weekthree.dto.movie.MovieEntity;
import com.example.weekthree.dto.watchlist.WatchListDto;
import com.example.weekthree.dto.watchlist.WatchlistEntity;
import com.example.weekthree.models.ModifyList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class ModifyServiceImpl implements ModifyService{

    private final MovieDto movieDto;
    private final WatchListDto watchListDto;
    private final ModifylistDto modifylistDto;

    @Override
    public Long modifyListAdd(ModifyList modifyList) {
        MovieEntity movieEntity = movieDto.retrieve(modifyList.getMovieId());
        WatchlistEntity watchlistEntity = watchListDto.retrieve(modifyList.getWatchListId());
        ModifyListEntity modifyListEntity = modifyList.convertToModifyEntity(movieEntity,watchlistEntity);
        modifylistDto.addToList(modifyListEntity);
        return modifyListEntity.getId();
    }

    @Override
    public void remove(ModifyList modifyList) {
        ModifyListEntity modifyListEntity = modifylistDto.retrieve(modifyList);
        modifylistDto.remove(modifyListEntity);
    }

    @Override
    public List<Long> retreiveByWatchListId(Long watchListId) {
        return modifylistDto.findByMovies(watchListId);
    }


}
