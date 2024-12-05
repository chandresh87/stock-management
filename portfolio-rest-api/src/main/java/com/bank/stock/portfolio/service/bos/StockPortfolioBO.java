package com.bank.stock.portfolio.service.bos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StockPortfolioBO {

    private String symbol;
    private Integer quantity;
    private BigDecimal invested;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private BigDecimal price;
    private BigDecimal total;
    private BigDecimal change;

    public StockPortfolioBO() {
    }

    public String getSymbol() {
        return this.symbol;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public BigDecimal getInvested() {
        return this.invested;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public BigDecimal getChange() {
        return this.change;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setInvested(BigDecimal invested) {
        this.invested = invested;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof StockPortfolioBO)) return false;
        final StockPortfolioBO other = (StockPortfolioBO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$symbol = this.getSymbol();
        final Object other$symbol = other.getSymbol();
        if (this$symbol == null ? other$symbol != null : !this$symbol.equals(other$symbol)) return false;
        final Object this$quantity = this.getQuantity();
        final Object other$quantity = other.getQuantity();
        if (this$quantity == null ? other$quantity != null : !this$quantity.equals(other$quantity)) return false;
        final Object this$invested = this.getInvested();
        final Object other$invested = other.getInvested();
        if (this$invested == null ? other$invested != null : !this$invested.equals(other$invested)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        final Object this$updatedAt = this.getUpdatedAt();
        final Object other$updatedAt = other.getUpdatedAt();
        if (this$updatedAt == null ? other$updatedAt != null : !this$updatedAt.equals(other$updatedAt)) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$total = this.getTotal();
        final Object other$total = other.getTotal();
        if (this$total == null ? other$total != null : !this$total.equals(other$total)) return false;
        final Object this$change = this.getChange();
        final Object other$change = other.getChange();
        if (this$change == null ? other$change != null : !this$change.equals(other$change)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StockPortfolioBO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $symbol = this.getSymbol();
        result = result * PRIME + ($symbol == null ? 43 : $symbol.hashCode());
        final Object $quantity = this.getQuantity();
        result = result * PRIME + ($quantity == null ? 43 : $quantity.hashCode());
        final Object $invested = this.getInvested();
        result = result * PRIME + ($invested == null ? 43 : $invested.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $updatedAt = this.getUpdatedAt();
        result = result * PRIME + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $total = this.getTotal();
        result = result * PRIME + ($total == null ? 43 : $total.hashCode());
        final Object $change = this.getChange();
        result = result * PRIME + ($change == null ? 43 : $change.hashCode());
        return result;
    }

    public String toString() {
        return "StockPortfolioBO(symbol=" + this.getSymbol() + ", quantity=" + this.getQuantity() + ", invested=" + this.getInvested() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ", price=" + this.getPrice() + ", total=" + this.getTotal() + ", change=" + this.getChange() + ")";
    }
}