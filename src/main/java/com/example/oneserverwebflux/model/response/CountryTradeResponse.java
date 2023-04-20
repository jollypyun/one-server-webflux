package com.example.oneserverwebflux.model.response;

import java.util.List;

public record CountryTradeResponse(Integer currentCount,
                                   Integer numOfRows,
                                   Integer pageNo,
                                   Integer resultCode,
                                   Integer totalCount,
                                   String resultMsg,
                                   List<TradeData> data) {
}
