package com.coolflix.fraudchampion.Repository;
import com.coolflix.fraudchampion.Domain.Model.FraudChampionCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudChampCheckHistoryRepository extends JpaRepository<FraudChampionCheckHistory, Integer> {
}
