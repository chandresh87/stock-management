package com.bank.stock.portfolio.remote.dtos;

import lombok.Data;

import java.util.List;

@Data
public class StockSearchDTO {

    private List<BestMatchDTO> bestMatches;
}
