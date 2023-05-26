package com.coolflix.feed.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FeedConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() { return new RestTemplate(); }
}
