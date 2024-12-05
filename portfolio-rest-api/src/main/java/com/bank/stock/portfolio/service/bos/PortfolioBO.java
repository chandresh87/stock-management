package com.bank.stock.portfolio.service.bos;

import java.math.BigDecimal;
import java.util.List;

public class PortfolioBO {
    private List<StockPortfolioBO> portfolio;
    private BigDecimal totalPortfolio;
    private UsersBO userId;

    public PortfolioBO() {
    }

    public List<StockPortfolioBO> getPortfolio() {
        return this.portfolio;
    }

    public BigDecimal getTotalPortfolio() {
        return this.totalPortfolio;
    }

    public UsersBO getUserId() {
        return this.userId;
    }

    public void setPortfolio(List<StockPortfolioBO> portfolio) {
        this.portfolio = portfolio;
    }

    public void setTotalPortfolio(BigDecimal totalPortfolio) {
        this.totalPortfolio = totalPortfolio;
    }

    public void setUserId(UsersBO userId) {
        this.userId = userId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PortfolioBO)) return false;
        final PortfolioBO other = (PortfolioBO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$portfolio = this.getPortfolio();
        final Object other$portfolio = other.getPortfolio();
        if (this$portfolio == null ? other$portfolio != null : !this$portfolio.equals(other$portfolio)) return false;
        final Object this$totalPortfolio = this.getTotalPortfolio();
        final Object other$totalPortfolio = other.getTotalPortfolio();
        if (this$totalPortfolio == null ? other$totalPortfolio != null : !this$totalPortfolio.equals(other$totalPortfolio))
            return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PortfolioBO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $portfolio = this.getPortfolio();
        result = result * PRIME + ($portfolio == null ? 43 : $portfolio.hashCode());
        final Object $totalPortfolio = this.getTotalPortfolio();
        result = result * PRIME + ($totalPortfolio == null ? 43 : $totalPortfolio.hashCode());
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        return result;
    }

    public String toString() {
        return "PortfolioBO(portfolio=" + this.getPortfolio() + ", totalPortfolio=" + this.getTotalPortfolio() + ", userId=" + this.getUserId() + ")";
    }
}
