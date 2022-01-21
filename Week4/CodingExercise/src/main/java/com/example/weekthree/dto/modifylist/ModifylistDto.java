package com.example.weekthree.dto.modifylist;


import com.example.weekthree.models.ModifyList;

import java.util.List;

public interface ModifylistDto {
    void addToList(ModifyListEntity modifyListEntity);
    ModifyListEntity retrieve(ModifyList modifyList);
    void remove(ModifyListEntity modifyListEntity);
    List<Long> findByMovies(Long watchListId);
}

