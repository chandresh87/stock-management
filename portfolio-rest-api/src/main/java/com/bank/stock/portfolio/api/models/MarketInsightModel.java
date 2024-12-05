package com.bank.stock.portfolio.api.models;

import lombok.Data;

import java.util.List;

@Data
public class MarketInsightModel {
    private String metadata;
    private String lastUpdated;
    private List<TopGainerLooserModel> topGainers;
    private List<TopGainerLooserModel> topLosers;
    private List<TopGainerLooserModel> mostActivelyTraded;
}


