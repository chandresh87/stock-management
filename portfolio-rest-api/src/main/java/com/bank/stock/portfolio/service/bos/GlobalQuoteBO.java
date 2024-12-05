package com.bank.stock.portfolio.service.bos;

public class GlobalQuoteBO {

    private String symbol;

    private String open;

    private String high;

    private String low;

    private String price;

    private String volume;

    private String latestTradingDay;

    private String previousClose;

    private String change;

    private String changePercent;

    public GlobalQuoteBO() {
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getOpen() {
        return this.open;
    }

    public String getHigh() {
        return this.high;
    }

    public String getLow() {
        return this.low;
    }

    public String getPrice() {
        return this.price;
    }

    public String getVolume() {
        return this.volume;
    }

    public String getLatestTradingDay() {
        return this.latestTradingDay;
    }

    public String getPreviousClose() {
        return this.previousClose;
    }

    public String getChange() {
        return this.change;
    }

    public String getChangePercent() {
        return this.changePercent;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setLatestTradingDay(String latestTradingDay) {
        this.latestTradingDay = latestTradingDay;
    }

    public void setPreviousClose(String previousClose) {
        this.previousClose = previousClose;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public void setChangePercent(String changePercent) {
        this.changePercent = changePercent;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof GlobalQuoteBO)) return false;
        final GlobalQuoteBO other = (GlobalQuoteBO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$symbol = this.getSymbol();
        final Object other$symbol = other.getSymbol();
        if (this$symbol == null ? other$symbol != null : !this$symbol.equals(other$symbol)) return false;
        final Object this$open = this.getOpen();
        final Object other$open = other.getOpen();
        if (this$open == null ? other$open != null : !this$open.equals(other$open)) return false;
        final Object this$high = this.getHigh();
        final Object other$high = other.getHigh();
        if (this$high == null ? other$high != null : !this$high.equals(other$high)) return false;
        final Object this$low = this.getLow();
        final Object other$low = other.getLow();
        if (this$low == null ? other$low != null : !this$low.equals(other$low)) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$volume = this.getVolume();
        final Object other$volume = other.getVolume();
        if (this$volume == null ? other$volume != null : !this$volume.equals(other$volume)) return false;
        final Object this$latestTradingDay = this.getLatestTradingDay();
        final Object other$latestTradingDay = other.getLatestTradingDay();
        if (this$latestTradingDay == null ? other$latestTradingDay != null : !this$latestTradingDay.equals(other$latestTradingDay))
            return false;
        final Object this$previousClose = this.getPreviousClose();
        final Object other$previousClose = other.getPreviousClose();
        if (this$previousClose == null ? other$previousClose != null : !this$previousClose.equals(other$previousClose))
            return false;
        final Object this$change = this.getChange();
        final Object other$change = other.getChange();
        if (this$change == null ? other$change != null : !this$change.equals(other$change)) return false;
        final Object this$changePercent = this.getChangePercent();
        final Object other$changePercent = other.getChangePercent();
        if (this$changePercent == null ? other$changePercent != null : !this$changePercent.equals(other$changePercent))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GlobalQuoteBO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $symbol = this.getSymbol();
        result = result * PRIME + ($symbol == null ? 43 : $symbol.hashCode());
        final Object $open = this.getOpen();
        result = result * PRIME + ($open == null ? 43 : $open.hashCode());
        final Object $high = this.getHigh();
        result = result * PRIME + ($high == null ? 43 : $high.hashCode());
        final Object $low = this.getLow();
        result = result * PRIME + ($low == null ? 43 : $low.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $volume = this.getVolume();
        result = result * PRIME + ($volume == null ? 43 : $volume.hashCode());
        final Object $latestTradingDay = this.getLatestTradingDay();
        result = result * PRIME + ($latestTradingDay == null ? 43 : $latestTradingDay.hashCode());
        final Object $previousClose = this.getPreviousClose();
        result = result * PRIME + ($previousClose == null ? 43 : $previousClose.hashCode());
        final Object $change = this.getChange();
        result = result * PRIME + ($change == null ? 43 : $change.hashCode());
        final Object $changePercent = this.getChangePercent();
        result = result * PRIME + ($changePercent == null ? 43 : $changePercent.hashCode());
        return result;
    }

    public String toString() {
        return "GlobalQuoteBO(symbol=" + this.getSymbol() + ", open=" + this.getOpen() + ", high=" + this.getHigh() + ", low=" + this.getLow() + ", price=" + this.getPrice() + ", volume=" + this.getVolume() + ", latestTradingDay=" + this.getLatestTradingDay() + ", previousClose=" + this.getPreviousClose() + ", change=" + this.getChange() + ", changePercent=" + this.getChangePercent() + ")";
    }
}
