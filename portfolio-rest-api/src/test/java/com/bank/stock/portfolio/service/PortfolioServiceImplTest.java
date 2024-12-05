package com.bank.stock.portfolio.service;

import com.bank.stock.portfolio.api.models.Action;
import com.bank.stock.portfolio.repository.PortfolioEntity;
import com.bank.stock.portfolio.repository.PortfolioRepository;
import com.bank.stock.portfolio.service.bos.GlobalQuoteBO;
import com.bank.stock.portfolio.service.bos.PortfolioBO;
import com.bank.stock.portfolio.service.bos.StockDataBO;
import com.bank.stock.portfolio.service.bos.UpdatePortfolioBO;
import com.bank.stock.portfolio.service.bos.UsersBO;
import com.bank.stock.portfolio.service.exception.ServiceException;
import com.bank.stock.portfolio.service.mapper.PortfolioServiceMapper;
import com.bank.stock.portfolio.service.mapper.PortfolioServiceMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PortfolioServiceImplTest {

    @Mock
    private PortfolioRepository portfolioRepository;

    @Mock
    private StockService stockService;

    @InjectMocks
    private PortfolioServiceImpl portfolioService;

    @Spy
    private PortfolioServiceMapper portfolioServiceMapper = new PortfolioServiceMapperImpl();

    private static UsersBO getUsersBO() {
        UsersBO usersBO = new UsersBO();
        usersBO.setUserId(1);
        usersBO.setName("John");
        usersBO.setAddress("123 Main St");
        usersBO.setEmailId("<EMAIL>");
        return usersBO;
    }

    @Test
    void getUserPortfolio_nullUserId_throwsServiceException() {
        assertThrows(ServiceException.class, () -> portfolioService.getUserPortfolio(null));
    }

    @Test
    void getUserPortfolio_withStubbedRepository_returnsCorrectPortfolioBO() {
        Integer existingUserId = 1;
        PortfolioEntity portfolioEntity = new PortfolioEntity();
        portfolioEntity.setSymbol("AAPL");
        portfolioEntity.setQuantity(10);
        portfolioEntity.setInvested(new BigDecimal("1500"));
        portfolioEntity.setCreatedAt(LocalDateTime.now());

        when(portfolioRepository.findByUserId_UserId(existingUserId)).thenReturn(List.of(portfolioEntity));
        StockDataBO stockDataBO = new StockDataBO();
        GlobalQuoteBO globalQuoteBO = new GlobalQuoteBO();
        globalQuoteBO.setPrice("150");
        globalQuoteBO.setChangePercent("20.0");
        globalQuoteBO.setChange("10.0");
        globalQuoteBO.setSymbol("AAPL");
        stockDataBO.setGlobalQuote(globalQuoteBO);

        when(stockService.getStockData("AAPL")).thenReturn(stockDataBO);

        PortfolioBO portfolioBO = portfolioService.getUserPortfolio(existingUserId);

        assertNotNull(portfolioBO);
        assertEquals(1, portfolioBO.getPortfolio().size());
    }

    @Test
    void getUserPortfolio_withStubbedRepositoryEmptyList_returnsEmptyPortfolioBO() {
        Integer existingUserId = 2;

        when(portfolioRepository.findByUserId_UserId(existingUserId)).thenReturn(Collections.emptyList());

        PortfolioBO portfolioBO = portfolioService.getUserPortfolio(existingUserId);

        assertNotNull(portfolioBO);
    }

    @Test
    void updatePortfolio_nullUpdatePortfolioBO_throwsServiceException() {
        assertThrows(ServiceException.class, () -> portfolioService.updatePortfolio(null));
    }

    @Test
    void updatePortfolio_buyAction_updatesPortfolioCorrectly() {
        UpdatePortfolioBO updatePortfolioBO = new UpdatePortfolioBO();
        updatePortfolioBO.setAction(Action.BUY);
        updatePortfolioBO.setSymbol("AAPL");
        updatePortfolioBO.setQuantity(5);
        updatePortfolioBO.setPrice(new BigDecimal("150"));

        UsersBO usersBO = getUsersBO();
        updatePortfolioBO.setUsers(usersBO);
        when(portfolioRepository.findById("AAPL")).thenReturn(Optional.empty());

        portfolioService.updatePortfolio(updatePortfolioBO);


        var argumentCaptor = forClass(PortfolioEntity.class);
        verify(portfolioRepository).save(argumentCaptor.capture());
        PortfolioEntity capturedEntity = argumentCaptor.getValue();
        assertEquals("AAPL", capturedEntity.getSymbol());
        assertEquals(5, capturedEntity.getQuantity());
    }

    @Test
    void updatePortfolio_sellAction_updatesPortfolioCorrectly() {
        UpdatePortfolioBO updatePortfolioBO = new UpdatePortfolioBO();
        updatePortfolioBO.setAction(Action.SELL);
        updatePortfolioBO.setSymbol("AAPL");
        updatePortfolioBO.setQuantity(5);
        updatePortfolioBO.setPrice(new BigDecimal("150"));
        updatePortfolioBO.setUsers(getUsersBO());

        PortfolioEntity portfolioEntity = new PortfolioEntity();
        portfolioEntity.setSymbol("AAPL");
        portfolioEntity.setQuantity(10);
        portfolioEntity.setInvested(new BigDecimal("1500"));
        portfolioEntity.setCreatedAt(LocalDateTime.now());

        Optional<PortfolioEntity> optionalPortfolioEntity = Optional.of(portfolioEntity);

        when(portfolioRepository.findById("AAPL")).thenReturn(optionalPortfolioEntity);

        portfolioService.updatePortfolio(updatePortfolioBO);

        var argumentCaptor = forClass(PortfolioEntity.class);
        verify(portfolioRepository).save(argumentCaptor.capture());
        PortfolioEntity capturedEntity = argumentCaptor.getValue();
        assertEquals("AAPL", capturedEntity.getSymbol());
        assertEquals(5, capturedEntity.getQuantity());
    }

    @Test
    void updatePortfolio_sellAction_removesStockWhenQuantityEquals() {
        UpdatePortfolioBO updatePortfolioBO = new UpdatePortfolioBO();
        updatePortfolioBO.setAction(Action.SELL);
        updatePortfolioBO.setSymbol("AAPL");
        updatePortfolioBO.setQuantity(10);
        updatePortfolioBO.setPrice(new BigDecimal("150"));
        UsersBO usersBO = getUsersBO();
        updatePortfolioBO.setUsers(usersBO);

        PortfolioEntity portfolioEntity = new PortfolioEntity();
        portfolioEntity.setSymbol("AAPL");
        portfolioEntity.setQuantity(10);
        portfolioEntity.setInvested(new BigDecimal("1500"));
        portfolioEntity.setCreatedAt(LocalDateTime.now());

        Mockito.when(portfolioRepository.findById(any())).thenReturn(Optional.of(portfolioEntity));
        portfolioService.updatePortfolio(updatePortfolioBO);

        verify(portfolioRepository).delete(portfolioEntity);
    }

    @Test
    void updatePortfolio_sellAction_throwsExceptionWhenStockNotPresent() {
        UpdatePortfolioBO updatePortfolioBO = new UpdatePortfolioBO();
        updatePortfolioBO.setAction(Action.SELL);
        updatePortfolioBO.setSymbol("AAPL");
        updatePortfolioBO.setQuantity(5);
        updatePortfolioBO.setPrice(new BigDecimal("150"));
        UsersBO usersBO = getUsersBO();
        updatePortfolioBO.setUsers(usersBO);

        when(portfolioRepository.findById("AAPL")).thenReturn(Optional.empty());

        assertThrows(ServiceException.class, () -> portfolioService.updatePortfolio(updatePortfolioBO));
    }
}