package com.example.weekthree.dto.modifylist;


import com.example.weekthree.models.ModifyList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor

public class ModifyListDtoImpl implements ModifylistDto{

    private final  ModifyJpaDto modifyJpaDto;


    @Override
    public void addToList(ModifyListEntity modifyListEntity) {
        modifyJpaDto.save(modifyListEntity);
    }

    @Override
    public ModifyListEntity retrieve(ModifyList modifyList) {
       return modifyJpaDto.findByMovieIdAndWatchlistEntityWatchListId(modifyList.getMovieId(),modifyList.getWatchListId());
    }

    @Override
    public void remove(ModifyListEntity modifyListEntity) {
        modifyJpaDto.delete(modifyListEntity);
    }

    @Override
    public List<Long> findByMovies(Long watchListId) {
        List<ModifyListEntity> x = modifyJpaDto.findAllByWatchlistEntityWatchListIdIsIn(Collections.singleton(watchListId));
        return x.stream().map(modifyListEntity -> modifyListEntity.getMovie().getId())
                .toList();
    }


}
