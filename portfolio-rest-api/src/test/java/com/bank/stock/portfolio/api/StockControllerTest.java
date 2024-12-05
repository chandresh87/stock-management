package com.bank.stock.portfolio.api;

import com.bank.stock.portfolio.api.mapper.ApiMapper;
import com.bank.stock.portfolio.api.models.StockSearchModel;
import com.bank.stock.portfolio.service.StockService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StockService stockService;

    @MockBean
    private ApiMapper apiMapper;

    @Test
    void testSearchStock() throws Exception {
        String symbol = "AAPL";
        StockSearchModel stockSearchModel = new StockSearchModel();
        
        Mockito.when(stockService.searchStock(symbol)).thenReturn(any());


        mockMvc.perform(MockMvcRequestBuilders.get("/stock/search")
                .param("symbol", symbol)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").exists());
    }
}