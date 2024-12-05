package com.bank.stock.portfolio.api.models;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PortfolioModel {
    private List<StockPortfolioModel> portfolio;
    private BigDecimal totalPortfolio;
    private UsersModel userId;
}