package com.coolflix.fraudchampion.Domain.Service;

import com.coolflix.fraudchampion.Domain.Model.FraudChampionCheckHistory;
import com.coolflix.fraudchampion.Repository.FraudChampCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudChampionCheckService {
    private final FraudChampCheckHistoryRepository fraudChampCheckHistoryRepository;

    public boolean isFraudulentChampion(Integer championId) {
        fraudChampCheckHistoryRepository.save(
                FraudChampionCheckHistory.builder()
                        .championId(championId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
