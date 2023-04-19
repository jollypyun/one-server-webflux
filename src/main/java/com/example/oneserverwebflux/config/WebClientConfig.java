package com.example.oneserverwebflux.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class WebClientConfig {
    @Value("${client.url}")
    private String url;

    @Bean
    public WebClient webClient() {
        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(url);
        uriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
        return WebClient.builder()
                .uriBuilderFactory(uriBuilderFactory)
                .build();
    }
}
