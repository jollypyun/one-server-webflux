package com.example.oneserverwebflux.model.response;

import com.example.oneserverwebflux.model.entity.Trade;

public record TradeData(String country_eng_nm,
                        String country_iso_alp2,
                        String country_nm,
                        String export_cn,
                        String income_cn,
                        Long yt_export_amount,
                        Long yt_income_amount,
                        String yt_trade_year) {
    public Trade of() {
        return Trade.builder()
                .countryEngNm(this.country_eng_nm)
                .countryIsoAlp2(this.country_iso_alp2)
                .countryNm(this.country_nm)
                .exportCn(this.export_cn)
                .incomeCn(this.income_cn)
                .ytExportAmount(this.yt_export_amount)
                .ytIncomeAmount(this.yt_income_amount)
                .ytTradeYear(this.yt_trade_year)
                .build();
    }
}
