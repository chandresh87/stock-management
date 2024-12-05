package com.bank.stock.portfolio.service.bos;

import lombok.Data;

import java.util.List;

@Data
public class MarketInsightBO {
    private String metadata;
    private String lastUpdated;
    private List<TopGainerLooserBO> topGainers;
    private List<TopGainerLooserBO> topLosers;
    private List<TopGainerLooserBO> mostActivelyTraded;
}


