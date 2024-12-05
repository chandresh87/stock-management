package com.bank.stock.portfolio.api.models;

import com.bank.stock.portfolio.service.bos.UsersBO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class StockPortfolioModel {

    private String symbol;
    private Integer quantity;
    private String invested;
    private LocalDateTime createdAt;
    private LocalDateTime  updatedAt;
    private BigDecimal price;
    private BigDecimal total;
    private BigDecimal change;
}