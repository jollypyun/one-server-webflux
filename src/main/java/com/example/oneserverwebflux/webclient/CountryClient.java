package com.example.oneserverwebflux.webclient;

import com.example.oneserverwebflux.model.request.SearchRequest;
import com.example.oneserverwebflux.model.response.CountryTradeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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

    public Mono<CountryTradeResponse> getTradeAll(SearchRequest request) {
        return webClient.get()
                .uri(uriBuilder -> buildURI(uriBuilder, request))
                .retrieve()
                .bodyToMono(CountryTradeResponse.class);
    }

    private URI buildURI(UriBuilder uriBuilder, SearchRequest request) {
        uriBuilder
                .path(pathUrl)
                .queryParam(SERVICE_KEY, encode)
                .queryParam(PAGE_NO, request.pageNo())
                .queryParam(NUM_OF_ROWS, request.numOfRows());
        if(StringUtils.hasLength(request.name())) {
            try {
                uriBuilder.queryParam(COUNTRY_NM, URLEncoder.encode(request.name(), StandardCharsets.UTF_8));
            } catch (Exception e)  {
                uriBuilder.queryParam(COUNTRY_NM, "");
            }
        }
        if(StringUtils.hasLength(request.iso())) {
            uriBuilder.queryParam(COUNTRY_ISO_ALP2, request.iso());
        }
        return uriBuilder.build();
    }
}
