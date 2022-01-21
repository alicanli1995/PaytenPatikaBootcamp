package com.example.weekthree.services.modifylist;


import com.example.weekthree.models.ModifyList;

import java.util.List;

public interface ModifyService {
    Long modifyListAdd(ModifyList modifyList);
    void remove(ModifyList modifyList);
    List<Long> retreiveByWatchListId(Long watchListId);
}
