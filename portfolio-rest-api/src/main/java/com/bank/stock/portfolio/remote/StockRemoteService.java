package com.bank.stock.portfolio.remote;

import com.bank.stock.portfolio.remote.dtos.CompanyDetailsDTO;
import com.bank.stock.portfolio.remote.dtos.MarketInsightDTO;
import com.bank.stock.portfolio.remote.dtos.StockDataDTO;
import com.bank.stock.portfolio.remote.dtos.StockSearchDTO;

public interface StockRemoteService {

    StockSearchDTO searchStock(String symbol);
    MarketInsightDTO marketInsight();
    StockDataDTO getStockData(String symbol);
    CompanyDetailsDTO getCompanyOverview(String symbol);
}
