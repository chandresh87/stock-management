package com.bank.stock.portfolio.remote.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MarketInsightDTO{
    private String metadata;
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonProperty("top_gainers")
    private List<TopGainerLooserDTO> topGainers;
    @JsonProperty("top_losers")
    private List<TopGainerLooserDTO> topLosers;
    @JsonProperty("most_actively_traded")
    private List<TopGainerLooserDTO> mostActivelyTraded;
}


