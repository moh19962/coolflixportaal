package com.coolflix.clients.feed;

import java.time.LocalDateTime;

public record FeedCheckResponse(
        Integer id,
        Integer customerId,
        String title,
        String description,
        LocalDateTime date
) {
}
