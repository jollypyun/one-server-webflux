package com.example.oneserverwebflux.serviceimpl;

import com.example.oneserverwebflux.model.entity.Trade;
import com.example.oneserverwebflux.model.request.SearchRequest;
import com.example.oneserverwebflux.model.response.CountryTradeResponse;
import com.example.oneserverwebflux.model.response.TradeData;
import com.example.oneserverwebflux.repository.TradeRepository;
import com.example.oneserverwebflux.service.CountryService;
import com.example.oneserverwebflux.webclient.CountryClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryServiceImpl implements CountryService {

    private final CountryClient countryClient;
    private final TradeRepository tradeRepository;

    @Override
    @Transactional
    public Mono<CountryTradeResponse> getInfo(SearchRequest request) {
        var tradeInfo = countryClient.getTradeAll(request);
        Flux<TradeData> middle = tradeInfo.map(CountryTradeResponse::data).flatMapMany(Flux::fromIterable);
        Flux<Trade> flux = middle.map(TradeData::of);
        flux.map(trade -> {
            System.out.println("" + trade.getId());
            return null;
        });
        tradeRepository.saveAll(flux);
        return tradeInfo;
    }
}
