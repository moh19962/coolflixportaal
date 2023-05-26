package com.coolflix.feed.Controller;

import com.coolflix.feed.Domain.Request.FeedRegistrationRequest;
import com.coolflix.feed.Domain.Service.FeedService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/feed")
@AllArgsConstructor
public class FeedController {

    private final FeedService feedService;

    @PostMapping
    public void registerFeed(@RequestBody FeedRegistrationRequest feedRegistrationRequest) {
        log.info("new customer registration {}", feedRegistrationRequest);
        feedService.registerFeed(feedRegistrationRequest);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
