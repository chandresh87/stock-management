package com.bank.stock.portfolio.service;

import com.bank.stock.portfolio.service.bos.CompanyDetailsBO;
import com.bank.stock.portfolio.service.bos.MarketInsightBO;
import com.bank.stock.portfolio.service.bos.StockDataBO;
import com.bank.stock.portfolio.service.bos.StockSearchBO;

public interface StockService {

    StockSearchBO searchStock(String symbol);
    MarketInsightBO marketInsight();
    StockDataBO getStockData(String symbol);
    CompanyDetailsBO getCompanyOverview(String symbol);

}
