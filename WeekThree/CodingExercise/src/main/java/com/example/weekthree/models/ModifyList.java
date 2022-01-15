package com.example.weekthree.models;


import com.example.weekthree.dto.ModifyListEntity;
import com.example.weekthree.dto.MovieEntity;
import com.example.weekthree.dto.WatchlistEntity;
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
        entity.setWatchlistId(watchListId);
        entity.setMoviesId(movieId);
        entity.setMovie(movieEntity);
        entity.setWatchlistEntity(watchlistEntity);
        return entity;
    }


    public ModifyListEntity convertToMovieEntity(ModifyList modifyList) {
        ModifyListEntity modifyListEntity = new ModifyListEntity();
        modifyListEntity.setWatchlistId(modifyList.getWatchListId());
        modifyListEntity.setMoviesId(modifyList.getMovieId());
        return modifyListEntity;
    }

}
