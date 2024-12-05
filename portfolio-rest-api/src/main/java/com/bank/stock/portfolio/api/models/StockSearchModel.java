package com.bank.stock.portfolio.api.models;

import lombok.Data;

import java.util.List;

@Data
public class StockSearchModel {

    private List<BestMatchModel> bestMatches;
}
