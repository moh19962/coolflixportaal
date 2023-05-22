package com.coolflix.champion.Domain.Service;

import com.coolflix.champion.Domain.Model.Champion;
import com.coolflix.champion.Domain.Request.ChampionRegistrationRequest;
import com.coolflix.champion.Repository.ChampionRepository;
import com.coolflix.clients.championfraud.FraudChampionClient;
import com.coolflix.clients.championfraud.FraudCheckResponse;
import com.coolflix.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@AllArgsConstructor
public class ChampionService {
    private final ChampionRepository championRepository;
    private final RestTemplate restTemplate;
    private final FraudChampionClient championFraudClient;
    public void registerChampion(ChampionRegistrationRequest request) {
        Champion champion = Champion.builder()
                .name(request.name())
                .title(request.title())
                .role(request.role())
                .lore(request.lore())
                .build();
                // todo: check if email valid
                // todo: check if email not taken
                championRepository.saveAndFlush(champion);
                
              FraudCheckResponse fraudCheckResponse =
                      championFraudClient.isFraudster(champion.getId());

            if (fraudCheckResponse.isFraudster()) {
                throw new IllegalStateException("fraudster");
            }
            // todo: make it async. i.e add to queue
//            notificationClient.sendNotification(
//                    new NotificationRequest(
//                            customer.getId(),
//                            customer.getEmail(),
//                            String.format("Hi %s, welcome to Coolflix...",
//                                    customer.getFirstName())
//                    )
//            );
    }

}
