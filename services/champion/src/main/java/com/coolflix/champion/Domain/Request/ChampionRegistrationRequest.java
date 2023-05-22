package com.coolflix.champion.Domain.Request;

public record ChampionRegistrationRequest(
        String name,
        String title,
        String role,
        String lore) {
}
