package com.bank.stock.portfolio.service.bos;


import lombok.Data;

@Data
public class CompanyDetailsBO {
    
    private String symbol;
    
    private String assetType;
    
    private String name;
    
    private String description;
    
    private String cIK;
    
    private String exchange;
    
    private String currency;
    
    private String country;
    
    private String sector;
    
    private String industry;
    
    private String address;
    
    private String officialSite;
    
    private String fiscalYearEnd;
    
    private String latestQuarter;
    
    private String marketCapitalization;
    
    private String eBITDA;
    
    private String pERatio;
    
    private String pEGRatio;
    
    private String bookValue;
    
    private String dividendPerShare;
    
    private String dividendYield;
    
    private String ePS;
    
    private String revenuePerShareTTM;
    
    private String profitMargin;
    
    private String operatingMarginTTM;
    
    private String returnOnAssetsTTM;
    
    private String returnOnEquityTTM;
    
    private String revenueTTM;
    
    private String grossProfitTTM;
    
    private String dilutedEPSTTM;
    
    private String quarterlyEarningsGrowthYOY;
    
    private String quarterlyRevenueGrowthYOY;
    
    private String analystTargetPrice;
    
    private String analystRatingStrongBuy;
    
    private String analystRatingBuy;
    
    private String analystRatingHold;
    
    private String analystRatingSell;
    
    private String analystRatingStrongSell;
    
    private String trailingPE;
    
    private String forwardPE;
    
    private String priceToSalesRatioTTM;
    
    private String priceToBookRatio;
    
    private String eVToRevenue;
    
    private String eVToEBITDA;
    
    private String beta;
    
    private String _52WeekHigh;
    
    private String _52WeekLow;
    
    private String _50DayMovingAverage;
    
    private String _200DayMovingAverage;
    
    private String sharesOutstanding;
    
    private String dividendDate;
    
    private String exDividendDate;
}