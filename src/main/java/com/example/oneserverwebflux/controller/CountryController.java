package com.example.oneserverwebflux.controller;

import com.example.oneserverwebflux.model.request.SearchRequest;
import com.example.oneserverwebflux.model.response.CountryTradeResponse;
import com.example.oneserverwebflux.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/trade")
    public Mono<CountryTradeResponse> getInfo(SearchRequest request) {
        return countryService.getInfo(request);
    }
}
