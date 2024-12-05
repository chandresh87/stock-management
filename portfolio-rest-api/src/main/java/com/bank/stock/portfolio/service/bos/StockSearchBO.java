package com.bank.stock.portfolio.service.bos;

import lombok.Data;

import java.util.List;

@Data
public class StockSearchBO {

    private List<BestMatchBO> bestMatches;
}
