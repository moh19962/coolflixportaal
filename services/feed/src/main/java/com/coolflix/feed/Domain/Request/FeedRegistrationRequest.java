package com.coolflix.feed.Domain.Request;

import java.time.LocalDateTime;

public record FeedRegistrationRequest(
        Integer customerId,
        String title,
        String description,
        LocalDateTime date) {
}
