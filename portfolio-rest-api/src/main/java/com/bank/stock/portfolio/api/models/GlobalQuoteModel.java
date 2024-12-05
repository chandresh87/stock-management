package com.bank.stock.portfolio.api.models;

import lombok.Data;

@Data
public class GlobalQuoteModel {

    private String symbol;

    private String open;

    private String high;

    private String low;

    private String price;

    private String volume;

    private String latestTradingDay;

    private String previousClose;

    private String change;

    private String changePercent;
}
