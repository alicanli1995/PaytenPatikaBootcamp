package com.example.weekthree.dto.matching;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class MatchingDtoImpl implements MatchingDto{

    private final MathingJpaDto mathingJpaDto;

    @Override
    public void saveMatching(List<MatchingEntity> matchingEntityList) {
         mathingJpaDto.saveAll(matchingEntityList);
    }
}
