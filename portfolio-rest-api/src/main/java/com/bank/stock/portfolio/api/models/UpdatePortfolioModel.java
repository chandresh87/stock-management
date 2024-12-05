package com.bank.stock.portfolio.api.models;

import java.math.BigDecimal;

public class UpdatePortfolioModel {

    private String symbol;
    private Integer quantity;
    private BigDecimal price;
    private UsersModel users;
    private Action action;

    public UpdatePortfolioModel() {
    }

    public String getSymbol() {
        return this.symbol;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public UsersModel getUsers() {
        return this.users;
    }

    public Action getAction() {
        return this.action;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setUsers(UsersModel users) {
        this.users = users;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UpdatePortfolioModel)) return false;
        final UpdatePortfolioModel other = (UpdatePortfolioModel) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$symbol = this.getSymbol();
        final Object other$symbol = other.getSymbol();
        if (this$symbol == null ? other$symbol != null : !this$symbol.equals(other$symbol)) return false;
        final Object this$quantity = this.getQuantity();
        final Object other$quantity = other.getQuantity();
        if (this$quantity == null ? other$quantity != null : !this$quantity.equals(other$quantity)) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$users = this.getUsers();
        final Object other$users = other.getUsers();
        if (this$users == null ? other$users != null : !this$users.equals(other$users)) return false;
        final Object this$action = this.getAction();
        final Object other$action = other.getAction();
        if (this$action == null ? other$action != null : !this$action.equals(other$action)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UpdatePortfolioModel;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $symbol = this.getSymbol();
        result = result * PRIME + ($symbol == null ? 43 : $symbol.hashCode());
        final Object $quantity = this.getQuantity();
        result = result * PRIME + ($quantity == null ? 43 : $quantity.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $users = this.getUsers();
        result = result * PRIME + ($users == null ? 43 : $users.hashCode());
        final Object $action = this.getAction();
        result = result * PRIME + ($action == null ? 43 : $action.hashCode());
        return result;
    }

    public String toString() {
        return "UpdatePortfolioModel(symbol=" + this.getSymbol() + ", quantity=" + this.getQuantity() + ", price=" + this.getPrice() + ", users=" + this.getUsers() + ", action=" + this.getAction() + ")";
    }
}
