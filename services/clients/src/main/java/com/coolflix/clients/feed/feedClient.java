package com.coolflix.clients.feed;

import com.coolflix.feed.Domain.Model.Feed;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("feed")
public interface feedClient {
//    @GetMapping(path = "api/v1/feed/customer/{customerId}")
//    ResponseEntity<List<Feed>> getFeedByCustomerId(@Param("customerId")Integer customerId);
}
