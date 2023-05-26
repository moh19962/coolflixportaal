package com.coolflix.champion.Controller;

import com.coolflix.champion.Domain.Model.Champion;
import com.coolflix.champion.Domain.Request.ChampionRegistrationRequest;
import com.coolflix.champion.Domain.Service.ChampionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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

    @GetMapping()
    public ResponseEntity<List<Champion>> getAllVehicles (){
        try{
            List<Champion> champions = championService.findAll();
            return ResponseEntity.ok().body(champions);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Champion>getChampionById(@PathVariable(value = "id")Integer id){
        try{
            Champion champion = championService.findById(id);
            return ResponseEntity.ok().body(champion);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<Champion> updateChampion(@RequestBody Champion champion){
        try{
            championService.updateChampion(champion);
            return ResponseEntity.ok().body(champion);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteChampion(@PathVariable(value = "id") Integer id){
        try{
            championService.deleteChampion(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
