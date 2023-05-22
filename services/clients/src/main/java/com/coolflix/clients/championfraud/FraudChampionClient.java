package com.coolflix.clients.championfraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "fraudchampion",
        url = "${clients.fraudchampion.url}"
)
public interface FraudChampionClient {

    @GetMapping(path = "api/v1/fraud-check/{championId}")
        FraudCheckResponse isFraudster(
                @PathVariable("championId") Integer championId);
}
