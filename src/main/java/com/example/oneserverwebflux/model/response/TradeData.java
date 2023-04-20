package com.example.oneserverwebflux.model.response;

public record TradeData(String country_eng_nm,
                        String country_iso_alp2,
                        String country_nm,
                        String export_cn,
                        String income_cn,
                        Long yt_export_amount,
                        Long yt_income_amount,
                        String yt_trade_year) {
}
