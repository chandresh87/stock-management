package com.bank.stock.portfolio.service.mapper;

import com.bank.stock.portfolio.remote.dtos.*;
import com.bank.stock.portfolio.service.bos.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StockServiceMapper {


    StockSearchBO stockSearchDTOToBO(StockSearchDTO stockSearchDTO);
    MarketInsightBO marketInsightDTOToBO(MarketInsightDTO marketInsightDTO);
    StockDataBO stockDataDTOToBO(StockDataDTO stockDataDTO);
    CompanyDetailsBO companyDetailsDTOToBO(CompanyDetailsDTO companyDetailsDTO);





}
