package com.bank.stock.portfolio.remote;

import com.bank.stock.portfolio.remote.dtos.CompanyDetailsDTO;
import com.bank.stock.portfolio.remote.dtos.MarketInsightDTO;
import com.bank.stock.portfolio.remote.dtos.StockDataDTO;
import com.bank.stock.portfolio.remote.dtos.StockSearchDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockRemoteServiceImpl implements StockRemoteService {

    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final String apiKey;

    public StockRemoteServiceImpl(RestTemplate restTemplate, @Value("${stock.api.host}") String baseUrl, @Value("${stock.api.api-key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }

    @Override
    public StockSearchDTO searchStock(String symbol) {

        HttpEntity<Object> entity = getHttpEntity();

        String url = this.baseUrl + "?function=SYMBOL_SEARCH&keywords={symbol}&apikey={apiKey}";
        ResponseEntity<StockSearchDTO> searchDTOResponseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, StockSearchDTO.class, symbol, apiKey);
        return searchDTOResponseEntity.getBody();
    }

    @Override
    public MarketInsightDTO marketInsight() {
        String url = this.baseUrl + "?function=TOP_GAINERS_LOSERS&apikey={apiKey}";
        HttpEntity<Object> entity = getHttpEntity();
        ResponseEntity<MarketInsightDTO> marketInsightDTOResponseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, MarketInsightDTO.class, apiKey);
        return marketInsightDTOResponseEntity.getBody();
    }

    @Override
    public StockDataDTO getStockData(String symbol) {

        String url = this.baseUrl + "?function=GLOBAL_QUOTE&symbol={symbol}&apikey={apiKey}";
        HttpEntity<Object> entity = getHttpEntity();
        ResponseEntity<StockDataDTO> stockDataDTOResponseEntity =
                restTemplate.exchange(url, HttpMethod.GET, entity, StockDataDTO.class, symbol, apiKey);
        return stockDataDTOResponseEntity.getBody();
    }

    @Override
    public CompanyDetailsDTO getCompanyOverview(String symbol) {
        String url = this.baseUrl + "?function=OVERVIEW&symbol={symbol}&apikey={apiKey}";
        HttpEntity<Object> entity = getHttpEntity();
        ResponseEntity<CompanyDetailsDTO> companyDetailsResponseEntity =
                restTemplate.exchange(url, HttpMethod.GET, entity, CompanyDetailsDTO.class, symbol, apiKey);
        return companyDetailsResponseEntity.getBody();
    }

    private HttpEntity<Object> getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }
}
