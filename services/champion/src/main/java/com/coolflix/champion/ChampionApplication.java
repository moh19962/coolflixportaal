package com.coolflix.champion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(
        scanBasePackages = {
                "com.coolflix.champion",
                "com.coolflix.amqp",
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.coolflix.clients"
)
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class ChampionApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChampionApplication.class, args);
    }
}
