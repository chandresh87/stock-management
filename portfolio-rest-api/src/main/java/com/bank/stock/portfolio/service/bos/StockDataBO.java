package com.bank.stock.portfolio.service.bos;

public class StockDataBO {
    private GlobalQuoteBO globalQuote;

    public StockDataBO() {
    }

    public GlobalQuoteBO getGlobalQuote() {
        return this.globalQuote;
    }

    public void setGlobalQuote(GlobalQuoteBO globalQuote) {
        this.globalQuote = globalQuote;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof StockDataBO)) return false;
        final StockDataBO other = (StockDataBO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$globalQuote = this.getGlobalQuote();
        final Object other$globalQuote = other.getGlobalQuote();
        if (this$globalQuote == null ? other$globalQuote != null : !this$globalQuote.equals(other$globalQuote))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StockDataBO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $globalQuote = this.getGlobalQuote();
        result = result * PRIME + ($globalQuote == null ? 43 : $globalQuote.hashCode());
        return result;
    }

    public String toString() {
        return "StockDataBO(globalQuote=" + this.getGlobalQuote() + ")";
    }
}

