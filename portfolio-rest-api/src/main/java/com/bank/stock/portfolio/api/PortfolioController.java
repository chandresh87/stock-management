package com.bank.stock.portfolio.api;

import com.bank.stock.portfolio.api.mapper.ApiMapper;
import com.bank.stock.portfolio.api.models.Action;
import com.bank.stock.portfolio.api.models.PortfolioModel;
import com.bank.stock.portfolio.api.models.UpdatePortfolioModel;
import com.bank.stock.portfolio.api.models.UsersModel;
import com.bank.stock.portfolio.service.PortfolioService;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;

/**
 * PortfolioController is a REST controller that handles HTTP requests for managing a user's stock portfolio.
 * It provides endpoints to update and retrieve a user's portfolio.
 */
@RestController
@RequestMapping("portfolio/")
@CrossOrigin
@Tag(name = "Portfolio", description = "the portfolio API")
public class PortfolioController {

    private final ApiMapper apiMapper;
    private final PortfolioService portfolioService;

    public PortfolioController(ApiMapper apiMapper, PortfolioService portfolioService) {
        this.apiMapper = apiMapper;
        this.portfolioService = portfolioService;
    }

    @Operation(summary = "Update portfolio", description = "Updates a user's portfolio", tags = {"Portfolio"})
    @PostMapping(value = "update")
    public ResponseEntity updatePortfolio(@Parameter(description = "Portfolio update model") @RequestBody UpdatePortfolioModel updatePortfolioModel) {
        portfolioService.updatePortfolio(apiMapper.addStockModelToBO(updatePortfolioModel));
        if(updatePortfolioModel.getAction()== Action.BUY)
        {
            return new ResponseEntity(CREATED);
        }
        else
            return new ResponseEntity(ACCEPTED);
    }

    @Operation(summary = "Get portfolio", description = "Retrieves a user's portfolio", tags = {"Portfolio"})
    @GetMapping(value = "get", produces = "application/json")
    public PortfolioModel getPortfolio(@Parameter(description = "User ID") @RequestParam(name = "user") Integer userId) {
        return apiMapper.portfolioBOToModel(portfolioService.getUserPortfolio(userId));
    }

    @Operation(summary = "Get user details", description = "Retrieves details of a specific user", tags = {"Portfolio"})
    @GetMapping(value = "user", produces = "application/json")
    public UsersModel getUserDetails(@Parameter(description = "User ID") @RequestParam(name = "user") Integer userId) {
        return apiMapper.usersBOToModel(portfolioService.getUserDetail(userId));
    }
}
