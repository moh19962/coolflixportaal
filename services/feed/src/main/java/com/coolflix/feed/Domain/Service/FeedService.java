package com.coolflix.feed.Domain.Service;

import com.coolflix.feed.Domain.Model.Feed;
import com.coolflix.feed.Domain.Request.FeedRegistrationRequest;
import com.coolflix.feed.Repository.FeedRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class FeedService {
    private final FeedRepository feedRepository;
    public void registerFeed(FeedRegistrationRequest request) {
        Feed feed = Feed.builder()
                .customerId(request.customerId())
                .title(request.title())
                .description(request.description())
                .date(request.date())
                .build();
        //todo: check if email is valid
        //todo: check if email is not taken
        feedRepository.save(feed);
    }

    public List<Feed> findAll() {
        List<Feed> feeds = feedRepository.findAll();
        return feeds;
    }
//    public Feed findById(Integer id){
//        Feed feeds = feedRepository.findById(id).orElse(null);
//        return feeds;
//    }
//    public List<Feed> findByCustomerId(Integer customerId){
//        List<Feed> feeds = feedRepository.findAllCustomerId(customerId);
//        return feeds;
//    }
//    public void updateFeed(Feed feed){
//        if(feedRepository.findById(feed.getId())!= null){
//            feedRepository.save(feed);
//        }
//    }
//    public void deleteFeed(Integer id){
//        feedRepository.deleteById(id);
//    }

}
