package com.example.weekthree.models;


import com.example.weekthree.dto.modifylist.ModifyListEntity;
import com.example.weekthree.dto.movie.MovieEntity;
import com.example.weekthree.dto.watchlist.WatchlistEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode


public class ModifyList {

    private Long watchListId;
    private Long movieId;

    public ModifyListEntity convertToModifyEntity(MovieEntity movieEntity, WatchlistEntity watchlistEntity) {
        ModifyListEntity entity = new ModifyListEntity();
        entity.setMovie(movieEntity);
        entity.setWatchlistEntity(watchlistEntity);
        return entity;
    }

}
