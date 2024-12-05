package com.bank.stock.portfolio.remote.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;

public class StockDataDTO {
    @JsonProperty("Global Quote")
    private GlobalQuoteDTO globalQuote;

    public StockDataDTO() {
    }

    public GlobalQuoteDTO getGlobalQuote() {
        return this.globalQuote;
    }

    @JsonProperty("Global Quote")
    public void setGlobalQuote(GlobalQuoteDTO globalQuote) {
        this.globalQuote = globalQuote;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof StockDataDTO)) return false;
        final StockDataDTO other = (StockDataDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$globalQuote = this.getGlobalQuote();
        final Object other$globalQuote = other.getGlobalQuote();
        if (this$globalQuote == null ? other$globalQuote != null : !this$globalQuote.equals(other$globalQuote))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StockDataDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $globalQuote = this.getGlobalQuote();
        result = result * PRIME + ($globalQuote == null ? 43 : $globalQuote.hashCode());
        return result;
    }

    public String toString() {
        return "StockDataDTO(globalQuote=" + this.getGlobalQuote() + ")";
    }
}

