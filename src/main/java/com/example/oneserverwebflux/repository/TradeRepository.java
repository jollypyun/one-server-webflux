package com.example.oneserverwebflux.repository;

import com.example.oneserverwebflux.model.entity.Trade;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends R2dbcRepository<Trade, String> {
}
