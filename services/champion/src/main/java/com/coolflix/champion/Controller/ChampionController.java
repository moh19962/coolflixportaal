package com.coolflix.champion.Controller;

import com.coolflix.champion.Domain.Request.ChampionRegistrationRequest;
import com.coolflix.champion.Domain.Service.ChampionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/champions")
@AllArgsConstructor
public class ChampionController {

    private final ChampionService championService;

    @PostMapping
    public void registerChampion(@RequestBody ChampionRegistrationRequest championRegistrationRequest) {
        log.info("new champion registration {}", championRegistrationRequest);
        championService.registerChampion(championRegistrationRequest);
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
