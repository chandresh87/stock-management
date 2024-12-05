package com.bank.stock.portfolio.service;

import com.bank.stock.portfolio.remote.StockRemoteService;
import com.bank.stock.portfolio.remote.dtos.CompanyDetailsDTO;
import com.bank.stock.portfolio.remote.dtos.MarketInsightDTO;
import com.bank.stock.portfolio.remote.dtos.StockDataDTO;
import com.bank.stock.portfolio.remote.dtos.StockSearchDTO;
import com.bank.stock.portfolio.service.bos.CompanyDetailsBO;
import com.bank.stock.portfolio.service.bos.MarketInsightBO;
import com.bank.stock.portfolio.service.bos.StockDataBO;
import com.bank.stock.portfolio.service.bos.StockSearchBO;
import com.bank.stock.portfolio.service.exception.ServiceException;
import com.bank.stock.portfolio.service.mapper.StockServiceMapper;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    private final StockRemoteService stockRemoteService;
    private final StockServiceMapper stockServiceMapper;

    public StockServiceImpl(StockRemoteService stockRemoteService, StockServiceMapper stockServiceMapper) {
        this.stockRemoteService = stockRemoteService;
        this.stockServiceMapper = stockServiceMapper;
    }

    /**
*
 * @param symbol
 * @return
*/
    @Override
    public StockSearchBO searchStock(String symbol) {

        if(null == symbol || symbol.isEmpty())
            throw new ServiceException("Symbol cannot be null or empty");

        StockSearchDTO stockSearchDTO = stockRemoteService.searchStock(symbol);
        return stockServiceMapper.stockSearchDTOToBO(stockSearchDTO);
    }

    @Override
    public MarketInsightBO marketInsight() {

        MarketInsightDTO marketInsightDTO = stockRemoteService.marketInsight();
        return stockServiceMapper.marketInsightDTOToBO(marketInsightDTO);
    }

    @Override
    public StockDataBO getStockData(String symbol) {
        if(null == symbol || symbol.isEmpty()) {
            throw new ServiceException("Symbol cannot be null or empty");
        }
        StockDataDTO stockDataDTO = stockRemoteService.getStockData(symbol);
        return stockServiceMapper.stockDataDTOToBO(stockDataDTO);
    }

    @Override
    public CompanyDetailsBO getCompanyOverview(String symbol) {
        if(null == symbol || symbol.isEmpty())
            throw new ServiceException("Symbol cannot be null or empty");
        CompanyDetailsDTO companyOverview = stockRemoteService.getCompanyOverview(symbol);

        return stockServiceMapper.companyDetailsDTOToBO(companyOverview);
    }
}
