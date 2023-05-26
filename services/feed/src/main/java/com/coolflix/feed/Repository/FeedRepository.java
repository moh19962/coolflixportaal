package com.coolflix.feed.Repository;

import com.coolflix.feed.Domain.Model.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Integer> {
}
