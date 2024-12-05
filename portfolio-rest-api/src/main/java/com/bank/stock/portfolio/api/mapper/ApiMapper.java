package com.bank.stock.portfolio.api.mapper;

import com.bank.stock.portfolio.api.models.*;

import com.bank.stock.portfolio.service.bos.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApiMapper {

    StockSearchModel stockSearchBOToModel(StockSearchBO stockSearchBO);
    MarketInsightModel marketInsightBOToModel(MarketInsightBO marketInsightBO);
    StockDataModel stockDataBOToModel(StockDataBO stockDataBO);
    CompanyDetailModel companyDetailsBOToModel(CompanyDetailsBO companyDetailsBO);
    BestMatchModel bestMatchBOToModel(BestMatchBO bestMatchBO);
    StockPortfolioModel portfolioBOToModel(StockPortfolioBO stockPortfolioBO);
    List<StockPortfolioModel> portfolioListBOToModel(List<StockPortfolioBO> stockPortfolioBOList);
    PortfolioModel portfolioBOToModel(PortfolioBO portfolioBO);
    UsersBO usersModelToBO(UsersModel usersBO);
    UsersModel usersBOToModel(UsersBO usersBO);
    UpdatePortfolioBO addStockModelToBO(UpdatePortfolioModel addStockBO);
}
