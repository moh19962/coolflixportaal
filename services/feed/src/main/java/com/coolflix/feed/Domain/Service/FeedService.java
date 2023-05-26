package com.coolflix.feed.Domain.Service;

import com.coolflix.feed.Domain.Model.Feed;
import com.coolflix.feed.Domain.Request.FeedRegistrationRequest;
import com.coolflix.feed.Repository.FeedRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeedService {
    private final FeedRepository feedRepository;
    public void registerFeed(FeedRegistrationRequest request) {
        Feed feed = Feed.builder()
                .title(request.title())
                .description(request.description())
                .date(request.date())
                .build();
        //todo: check if email is valid
        //todo: check if email is not taken
        feedRepository.save(feed);
    }
}
