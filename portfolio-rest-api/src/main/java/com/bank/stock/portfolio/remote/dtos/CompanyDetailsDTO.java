package com.bank.stock.portfolio.remote.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CompanyDetailsDTO {
    @JsonProperty("Symbol")
    private String symbol;
    @JsonProperty("AssetType")
    private String assetType;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("CIK")
    private String cIK;
    @JsonProperty("Exchange")
    private String exchange;
    @JsonProperty("Currency")
    private String currency;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("Sector")
    private String sector;
    @JsonProperty("Industry")
    private String industry;
    @JsonProperty("Address")
    private String address;
    @JsonProperty("OfficialSite")
    private String officialSite;
    @JsonProperty("FiscalYearEnd")
    private String fiscalYearEnd;
    @JsonProperty("LatestQuarter")
    private String latestQuarter;
    @JsonProperty("MarketCapitalization")
    private String marketCapitalization;
    @JsonProperty("EBITDA")
    private String eBITDA;
    @JsonProperty("PERatio")
    private String pERatio;
    @JsonProperty("PEGRatio")
    private String pEGRatio;
    @JsonProperty("BookValue")
    private String bookValue;
    @JsonProperty("DividendPerShare")
    private String dividendPerShare;
    @JsonProperty("DividendYield")
    private String dividendYield;
    @JsonProperty("EPS")
    private String ePS;
    @JsonProperty("RevenuePerShareTTM")
    private String revenuePerShareTTM;
    @JsonProperty("ProfitMargin")
    private String profitMargin;
    @JsonProperty("OperatingMarginTTM")
    private String operatingMarginTTM;
    @JsonProperty("ReturnOnAssetsTTM")
    private String returnOnAssetsTTM;
    @JsonProperty("ReturnOnEquityTTM")
    private String returnOnEquityTTM;
    @JsonProperty("RevenueTTM")
    private String revenueTTM;
    @JsonProperty("GrossProfitTTM")
    private String grossProfitTTM;
    @JsonProperty("DilutedEPSTTM")
    private String dilutedEPSTTM;
    @JsonProperty("QuarterlyEarningsGrowthYOY")
    private String quarterlyEarningsGrowthYOY;
    @JsonProperty("QuarterlyRevenueGrowthYOY")
    private String quarterlyRevenueGrowthYOY;
    @JsonProperty("AnalystTargetPrice")
    private String analystTargetPrice;
    @JsonProperty("AnalystRatingStrongBuy")
    private String analystRatingStrongBuy;
    @JsonProperty("AnalystRatingBuy")
    private String analystRatingBuy;
    @JsonProperty("AnalystRatingHold")
    private String analystRatingHold;
    @JsonProperty("AnalystRatingSell")
    private String analystRatingSell;
    @JsonProperty("AnalystRatingStrongSell")
    private String analystRatingStrongSell;
    @JsonProperty("TrailingPE")
    private String trailingPE;
    @JsonProperty("ForwardPE")
    private String forwardPE;
    @JsonProperty("PriceToSalesRatioTTM")
    private String priceToSalesRatioTTM;
    @JsonProperty("PriceToBookRatio")
    private String priceToBookRatio;
    @JsonProperty("EVToRevenue")
    private String eVToRevenue;
    @JsonProperty("EVToEBITDA")
    private String eVToEBITDA;
    @JsonProperty("Beta")
    private String beta;
    @JsonProperty("52WeekHigh")
    private String _52WeekHigh;
    @JsonProperty("52WeekLow")
    private String _52WeekLow;
    @JsonProperty("50DayMovingAverage")
    private String _50DayMovingAverage;
    @JsonProperty("200DayMovingAverage")
    private String _200DayMovingAverage;
    @JsonProperty("SharesOutstanding")
    private String sharesOutstanding;
    @JsonProperty("DividendDate")
    private String dividendDate;
    @JsonProperty("ExDividendDate")
    private String exDividendDate;
}