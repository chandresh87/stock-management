package com.bank.stock.portfolio.api;

import com.bank.stock.portfolio.api.mapper.ApiMapper;
import com.bank.stock.portfolio.api.models.Action;
import com.bank.stock.portfolio.api.models.UpdatePortfolioModel;
import com.bank.stock.portfolio.service.PortfolioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    @ExtendWith(MockitoExtension.class)
    @WebMvcTest(PortfolioController.class)
public class PortfolioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PortfolioService portfolioService;

    @MockBean
    private ApiMapper apiMapper;

    @Test
    public void testUpdatePortfolioBuyActionReturnsCreatedStatus() throws Exception {
        UpdatePortfolioModel updatePortfolioModel = new UpdatePortfolioModel();
        updatePortfolioModel.setSymbol("AAPL");
        updatePortfolioModel.setQuantity(10);
        updatePortfolioModel.setPrice(new BigDecimal("150.00"));
        updatePortfolioModel.setAction(Action.BUY);

        mockMvc.perform(post("/portfolio/update")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"symbol\":\"AAPL\",\"quantity\":10,\"price\":150.00,\"action\":\"BUY\"}"))
               .andExpect(status().isCreated());
    }

    @Test
    public void testUpdatePortfolioSellActionReturnsAcceptedStatus() throws Exception {
        UpdatePortfolioModel updatePortfolioModel = new UpdatePortfolioModel();
        updatePortfolioModel.setSymbol("GOOGL");
        updatePortfolioModel.setQuantity(5);
        updatePortfolioModel.setPrice(new BigDecimal("2000.00"));
        updatePortfolioModel.setAction(Action.SELL);

        mockMvc.perform(post("/portfolio/update")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"symbol\":\"GOOGL\",\"quantity\":5,\"price\":2000.00,\"action\":\"SELL\"}"))
               .andExpect(status().isAccepted());
    }
}