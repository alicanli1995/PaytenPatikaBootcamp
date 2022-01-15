package com.example.weekthree.dto;


import com.example.weekthree.models.ModifyList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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
       return modifyJpaDto.findByMoviesIdAndWatchlistId(modifyList.getMovieId(),modifyList.getWatchListId());
    }

    @Override
    public void remove(ModifyListEntity modifyListEntity) {
        modifyJpaDto.delete(modifyListEntity);
    }


}
