package com.coolflix.feed.Repository;

import com.coolflix.feed.Domain.Model.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedRepository extends JpaRepository<Feed, Integer> {
//    Feed findByUserId(Integer customerId);
//
//    List<Feed> findAllByOwnerId(Long customerId);

//    List<Feed> findAllByCustomerId(Integer customerId);

}
