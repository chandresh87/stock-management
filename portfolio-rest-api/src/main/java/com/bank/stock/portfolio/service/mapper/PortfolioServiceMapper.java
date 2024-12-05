package com.bank.stock.portfolio.service.mapper;

import com.bank.stock.portfolio.repository.PortfolioEntity;
import com.bank.stock.portfolio.repository.UsersEntity;
import com.bank.stock.portfolio.service.bos.StockPortfolioBO;
import com.bank.stock.portfolio.service.bos.UsersBO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PortfolioServiceMapper {

    List<StockPortfolioBO> PortfolioEntityToPortfolioBOList(List<PortfolioEntity> portfolioEntity);
    StockPortfolioBO PortfolioEntityToPortfolioBO(PortfolioEntity portfolioEntity);
    UsersBO userEntityToUsersBO(UsersEntity usersEntity);
    UsersEntity usersBOToUserEntity(UsersBO usersBO);
}
