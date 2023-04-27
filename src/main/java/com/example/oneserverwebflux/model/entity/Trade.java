package com.example.oneserverwebflux.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Trade {
    private String countryEngNm;
    private String countryIsoAlp2;
    private String countryNm;
    private String exportCn;
    private String incomeCn;
    private Long ytExportAmount;
    private Long ytIncomeAmount;
    private String ytTradeYear;
}
