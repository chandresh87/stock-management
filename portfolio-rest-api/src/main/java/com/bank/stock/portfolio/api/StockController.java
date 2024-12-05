package com.bank.stock.portfolio.api;

import com.bank.stock.portfolio.api.mapper.ApiMapper;
import com.bank.stock.portfolio.api.models.CompanyDetailModel;
import com.bank.stock.portfolio.api.models.MarketInsightModel;
import com.bank.stock.portfolio.api.models.StockDataModel;
import com.bank.stock.portfolio.api.models.StockSearchModel;
import com.bank.stock.portfolio.service.StockService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;


/**
 * StockController is a REST controller responsible for handling HTTP requests
 * related to stock information. It acts as an interface between the client-side
 * application and the backend services that provide stock data.
 */
@RestController
@CrossOrigin
public class StockController {

    private final ApiMapper apiMapper;
    private final StockService stockService;

    public StockController(ApiMapper apiMapper, StockService stockService) {
        this.apiMapper = apiMapper;
        this.stockService = stockService;
    }

    @Operation(summary = "Search stock by symbol", description = "Provides stock search data based on the symbol provided.")
    @GetMapping(value = "/stock/search", produces = "application/json")
    public StockSearchModel searchStock( @RequestParam String symbol)
    {
        return apiMapper.stockSearchBOToModel(stockService.searchStock(symbol));
    }

    @Operation(summary = "Get market insight", description = "Retrieves market insights data.")
    @GetMapping(value = "insight", produces = "application/json")
    public MarketInsightModel getMarketInsight()
    {
        return apiMapper.marketInsightBOToModel(stockService.marketInsight());
    }

    @Operation(summary = "Get stock data", description = "Retrieves data for a specific stock using the symbol.")
    @GetMapping(value = "/stock", produces = "application/json")
    public StockDataModel getStockData(@RequestParam String symbol)
    {
        return apiMapper.stockDataBOToModel(stockService.getStockData(symbol));
    }

    @Operation(summary = "Get company details", description = "Provides detailed information about a company based on the symbol.")
    @GetMapping(value = "/company/detail", produces = "application/json")
    public CompanyDetailModel getCompanyDetail(@RequestParam String symbol)
    {
        return apiMapper.companyDetailsBOToModel(stockService.getCompanyOverview(symbol));
    }


}
