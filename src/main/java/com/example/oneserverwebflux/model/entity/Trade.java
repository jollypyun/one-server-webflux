package com.example.oneserverwebflux.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table("trade")
public class Trade {
    @Id
    @Column("id")
    private String id;
    @Column("country_eng_nm")
    private String countryEngNm;
    @Column("country_iso_alp2")
    private String countryIsoAlp2;
    @Column("country_nm")
    private String countryNm;
    @Column("export_cn")
    private String exportCn;
    @Column("income_cn")
    private String incomeCn;
    @Column("yt_export_amount")
    private Long ytExportAmount;
    @Column("yt_income_amount")
    private Long ytIncomeAmount;
    @Column("yt_trade_year")
    private String ytTradeYear;
}
