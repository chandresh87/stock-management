package com.bank.stock.portfolio.remote.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TopGainerLooserDTO {
    private String ticker;
    private String price;
    @JsonProperty("change_amount")
    private String changeAmount;
    @JsonProperty("change_percentage")
    private String changePercentage;
    private String volume;
}
