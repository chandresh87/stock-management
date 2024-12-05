package com.bank.stock.portfolio.service;

import com.bank.stock.portfolio.remote.StockRemoteService;
import com.bank.stock.portfolio.remote.dtos.StockSearchDTO;
import com.bank.stock.portfolio.service.bos.StockSearchBO;
import com.bank.stock.portfolio.service.exception.ServiceException;
import com.bank.stock.portfolio.service.mapper.StockServiceMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StockServiceImplTest {

    @Mock
    private StockRemoteService stockRemoteService;

    @Mock
    private StockServiceMapper stockServiceMapper;

    @InjectMocks
    private StockServiceImpl stockServiceImpl;

    @Test
    void testSearchStock_ValidSymbol() {
        // Given
        String validSymbol = "AAPL";
        StockSearchDTO stockSearchDTO = new StockSearchDTO();
        StockSearchBO expectedStockSearchBO = new StockSearchBO();
        
        when(stockRemoteService.searchStock(validSymbol)).thenReturn(stockSearchDTO);
        when(stockServiceMapper.stockSearchDTOToBO(stockSearchDTO)).thenReturn(expectedStockSearchBO);

        // When
        StockSearchBO result = stockServiceImpl.searchStock(validSymbol);

        // Then
        assertEquals(expectedStockSearchBO, result);
    }

    @Test
    void testSearchStock_NullSymbol() {
        // Given
        String nullSymbol = null;

        // When & Then
        assertThrows(ServiceException.class, () -> stockServiceImpl.searchStock(nullSymbol));
    }

    @Test
    void testSearchStock_EmptySymbol() {
        // Given
        String emptySymbol = "";

        // When & Then
        assertThrows(ServiceException.class, () -> stockServiceImpl.searchStock(emptySymbol));
    }
}