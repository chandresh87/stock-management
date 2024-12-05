package com.bank.stock.portfolio.service.bos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TopGainerLooserBO {
    private String ticker;
    private String price;
    private String changeAmount;
    private String changePercentage;
    private String volume;
}
