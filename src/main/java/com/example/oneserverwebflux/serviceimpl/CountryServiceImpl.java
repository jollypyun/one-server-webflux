package com.example.oneserverwebflux.serviceimpl;

import com.example.oneserverwebflux.model.request.SearchRequest;
import com.example.oneserverwebflux.service.CountryService;
import com.example.oneserverwebflux.webclient.CountryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryClient countryClient;

    @Override
    public Mono<String> getInfo(SearchRequest request) {
        return countryClient.getTradeAll(request);
    }
}
