package com.example.weekthree.dto;


import com.example.weekthree.models.ModifyList;

public interface ModifylistDto {
    void addToList(ModifyListEntity modifyListEntity);
    ModifyListEntity retrieve(ModifyList modifyList);
    void remove(ModifyListEntity modifyListEntity);
}

