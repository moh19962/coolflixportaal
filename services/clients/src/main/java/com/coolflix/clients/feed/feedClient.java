package com.coolflix.clients.feed;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("feed")
public interface feedClient {
//    @GetMapping(path = "api/v1/feed/{customerId}")
////    FeedCheckResponse getFeed(
////            @PathVariable("")
////    )

}
