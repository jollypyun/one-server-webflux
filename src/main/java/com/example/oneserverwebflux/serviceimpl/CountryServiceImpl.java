package com.example.oneserverwebflux.serviceimpl;

import com.example.oneserverwebflux.model.entity.Trade;
import com.example.oneserverwebflux.model.request.SearchRequest;
import com.example.oneserverwebflux.model.response.CountryTradeResponse;
import com.example.oneserverwebflux.repository.TradeRepository;
import com.example.oneserverwebflux.service.CountryService;
import com.example.oneserverwebflux.webclient.CountryClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryServiceImpl implements CountryService {

    private final CountryClient countryClient;
    private final TradeRepository tradeRepository;

    @Override
    public Mono<CountryTradeResponse> getInfo(SearchRequest request) {
        Mono<CountryTradeResponse> tradeInfo = countryClient.getTradeAll(request);
        List<Trade> list = tradeInfo.block().data().stream().map(tradeData -> tradeData.of()
        ).toList();
        return tradeInfo;
    }
}
