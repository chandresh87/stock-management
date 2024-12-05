package com.bank.stock.portfolio.api.models;

import lombok.Data;

@Data
public class TopGainerLooserModel {
    private String ticker;
    private String price;
    private String changeAmount;
    private String changePercentage;
    private String volume;
}
