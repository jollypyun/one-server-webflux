package com.example.oneserverwebflux.service;

import com.example.oneserverwebflux.model.request.SearchRequest;
import reactor.core.publisher.Mono;

public interface CountryService {
    Mono<String> getInfo(SearchRequest request);
}
