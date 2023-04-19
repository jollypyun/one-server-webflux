package com.example.oneserverwebflux.webclient;

import com.example.oneserverwebflux.model.request.SearchRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
@Slf4j
public class CountryClient {
    @Value("${client.path}")
    private String pathUrl;
    @Value("${client.key}")
    private String encode;

    private final WebClient webClient;
    private static final String SERVICE_KEY = "serviceKey";
    private static final String NUM_OF_ROWS = "numOfRows";
    private static final String PAGE_NO = "pageNo";
    private static final String COUNTRY_NM = "cond[country_nm::EQ]";
    private static final String COUNTRY_ISO_ALP2 = "cond[country_iso_alp2::EQ]";

    public Mono<String> getTradeAll(SearchRequest request) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(pathUrl)
                        .queryParam(SERVICE_KEY, encode)
                        .queryParam(PAGE_NO, request.pageNo())
                        .queryParam(NUM_OF_ROWS, request.numOfRows())
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }
}
