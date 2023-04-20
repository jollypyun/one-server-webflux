package com.example.oneserverwebflux.service;

import com.example.oneserverwebflux.model.request.SearchRequest;
import com.example.oneserverwebflux.model.response.CountryTradeResponse;
import reactor.core.publisher.Mono;

public interface CountryService {
    Mono<CountryTradeResponse> getInfo(SearchRequest request);
}
