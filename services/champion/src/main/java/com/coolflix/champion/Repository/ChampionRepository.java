package com.coolflix.champion.Repository;

import com.coolflix.champion.Domain.Model.Champion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChampionRepository extends JpaRepository<Champion, Integer> {

    //Define a method to fetch the item by Id
    Optional<Champion> findById(Long id);
}
