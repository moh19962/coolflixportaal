package com.coolflix.fraudchampion.Controller;

import com.coolflix.clients.championfraud.FraudCheckResponse;
import com.coolflix.fraudchampion.Domain.Service.FraudChampionCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudChampionController {
    private final FraudChampionCheckService fraudChampionCheckService;

    @GetMapping(path = "{championId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("championId") Integer championId) {
        boolean isFraudulentChampion = fraudChampionCheckService.
                isFraudulentChampion(championId);
        log.info("fraud check request for champion {}", championId);
        return new FraudCheckResponse(isFraudulentChampion);
    }
}
