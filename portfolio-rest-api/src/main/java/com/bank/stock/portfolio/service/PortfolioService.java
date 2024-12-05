package com.bank.stock.portfolio.service;

import com.bank.stock.portfolio.service.bos.UpdatePortfolioBO;
import com.bank.stock.portfolio.service.bos.PortfolioBO;
import com.bank.stock.portfolio.service.bos.StockPortfolioBO;
import com.bank.stock.portfolio.service.bos.UsersBO;

public interface PortfolioService {

    PortfolioBO getUserPortfolio(Integer userId);
    void updatePortfolio(UpdatePortfolioBO updatePortfolioBO);
    UsersBO getUserDetail(Integer userId);
}
