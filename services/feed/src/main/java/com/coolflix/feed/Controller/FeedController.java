package com.coolflix.feed.Controller;

import com.coolflix.feed.Domain.Model.Feed;
import com.coolflix.feed.Domain.Request.FeedRegistrationRequest;
import com.coolflix.feed.Domain.Service.FeedService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public ResponseEntity<List<Feed>> getAllFeed (){
        try{
            List<Feed> feeds = feedService.findAll();
            return ResponseEntity.ok().body(feeds);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<List<Feed>>getFeedByCustomerId(@PathVariable(value = "customerId")Integer customerId){
//        try{
//            List<Feed> feeds = feedService.findByCustomerId(customerId);
//            return ResponseEntity.ok().body(feeds);
//        }
//        catch (Exception e){
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
//    @PutMapping("/update")
//    public ResponseEntity<Feed> updateFeed(@RequestBody Feed feed){
//        try{
//            feedService.updateFeed(feed);
//            return ResponseEntity.ok().body(feed);
//        }
//        catch (Exception e){
//            return ResponseEntity.badRequest().build();
//        }
//    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity deleteFeed(@PathVariable(value = "id") Integer id){
//        try{
//            feedService.deleteFeed(id);
//            return ResponseEntity.ok().build();
//        }
//        catch (Exception e){
//            return ResponseEntity.badRequest().build();
//        }
//    }
}
