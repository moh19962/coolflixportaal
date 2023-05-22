package com.coolflix.fraud.Repository;

import com.coolflix.fraud.Domain.Model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
