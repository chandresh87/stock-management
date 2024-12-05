package com.bank.stock.portfolio.service;

import com.bank.stock.portfolio.api.models.Action;
import com.bank.stock.portfolio.repository.PortfolioEntity;
import com.bank.stock.portfolio.repository.PortfolioRepository;
import com.bank.stock.portfolio.repository.UserRepository;
import com.bank.stock.portfolio.repository.UsersEntity;
import com.bank.stock.portfolio.service.bos.PortfolioBO;
import com.bank.stock.portfolio.service.bos.StockDataBO;
import com.bank.stock.portfolio.service.bos.StockPortfolioBO;
import com.bank.stock.portfolio.service.bos.UpdatePortfolioBO;
import com.bank.stock.portfolio.service.bos.UsersBO;
import com.bank.stock.portfolio.service.exception.ServiceException;
import com.bank.stock.portfolio.service.mapper.PortfolioServiceMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class PortfolioServiceImpl implements PortfolioService {
    private final PortfolioRepository portfolioRepository;
    private final PortfolioServiceMapper portfolioServiceMapper;
    private final StockService stockService;
    private final Logger logger = LoggerFactory.getLogger(PortfolioServiceImpl.class);
    private final UserRepository userRepository;

    public PortfolioServiceImpl(PortfolioRepository portfolioRepository, PortfolioServiceMapper portfolioServiceMapper, StockService stockService, UserRepository userRepository) {
        this.portfolioRepository = portfolioRepository;
        this.portfolioServiceMapper = portfolioServiceMapper;
        this.stockService = stockService;
        this.userRepository = userRepository;
    }

    /**
*
 * @param userId
 * @return
*/
    @Override
    public PortfolioBO getUserPortfolio(Integer userId) {
        if(null == userId) {
            throw new ServiceException("user id is null");
        }
        PortfolioBO portfolioBO = new PortfolioBO();

        List<PortfolioEntity> portfolioEntities = portfolioRepository.findByUserId_UserId(userId);

        logger.info("getUserPortfolio portfolioEntities: {}", portfolioEntities);

        if(CollectionUtils.isNotEmpty(portfolioEntities)) {

            List<StockPortfolioBO> stockPortfolioBOS = portfolioServiceMapper.PortfolioEntityToPortfolioBOList(portfolioEntities);
            stockPortfolioBOS.forEach(stockPortfolioBO ->
            {
                logger.info("stockPortfolioBO: {}", stockPortfolioBO);
                StockDataBO stockData = stockService.getStockData(stockPortfolioBO.getSymbol());
                logger.info("stockData: {}", stockData);
                if (null != stockData && null != stockData.getGlobalQuote()) {
                    stockPortfolioBO.setPrice(new BigDecimal(stockData.getGlobalQuote().getPrice()));
                    BigDecimal total = stockPortfolioBO.getPrice().multiply(BigDecimal.valueOf(stockPortfolioBO.getQuantity()));
                    stockPortfolioBO.setTotal(total);
                    stockPortfolioBO.setChange(total.subtract(stockPortfolioBO.getInvested()));

                }
            });
            BigDecimal totalPortfolio = stockPortfolioBOS.stream().map(StockPortfolioBO::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
            logger.info("totalPortfolio: {}", totalPortfolio);
            portfolioBO.setPortfolio(stockPortfolioBOS);
            portfolioBO.setTotalPortfolio(totalPortfolio);
            UsersBO usersBO = portfolioServiceMapper.userEntityToUsersBO(portfolioEntities.getFirst().getUserId());
            portfolioBO.setUserId(usersBO);
        }
        return portfolioBO;
    }

    @Override
    public void updatePortfolio(UpdatePortfolioBO updatePortfolioBO) {
        if(null==updatePortfolioBO)
        {
            throw new ServiceException("updatePortfolioBO is null");
        }
        logger.info("updatePortfolioBO: {}", updatePortfolioBO);

        if( updatePortfolioBO.getAction()==Action.BUY)
        {
            buyStock(updatePortfolioBO);
        }
        else {
            sellStock(updatePortfolioBO);
        }
    }

    @Override
    public UsersBO getUserDetail(Integer userId) {

        UsersBO userBo = null;
        Optional<UsersEntity> usersEntity = userRepository.findById(userId);
        if(usersEntity.isPresent()) {
            userBo =  portfolioServiceMapper.userEntityToUsersBO(usersEntity.get());
        }
        return userBo;
    }


    /**
*
 * @param updatePortfolioBO
*/

    private StockPortfolioBO buyStock(UpdatePortfolioBO updatePortfolioBO) {
        PortfolioEntity portfolioEntitySaved;
        StockPortfolioBO portfolioBO;

        Optional<PortfolioEntity> portfolioEntityOptional = portfolioRepository.findById(updatePortfolioBO.getSymbol());
        if(portfolioEntityOptional.isPresent()) {
            PortfolioEntity portfolio = portfolioEntityOptional.get();
            portfolio.setQuantity(portfolio.getQuantity() + updatePortfolioBO.getQuantity());
            portfolio.setUpdatedAt(LocalDateTime.now());
            portfolio.setUserId(portfolioServiceMapper.usersBOToUserEntity(updatePortfolioBO.getUsers()));
            BigDecimal totalInvestment = updatePortfolioBO.getPrice().multiply(BigDecimal.valueOf(portfolio.getQuantity())).add(portfolio.getInvested());
            portfolio.setInvested(totalInvestment);
            portfolioEntitySaved = portfolioRepository.save(portfolio);
        }
        else {
            PortfolioEntity portfolio = new PortfolioEntity();
            portfolio.setSymbol(updatePortfolioBO.getSymbol());
            portfolio.setQuantity(updatePortfolioBO.getQuantity());
            portfolio.setCreatedAt(LocalDateTime.now());
            BigDecimal totalInvestment = updatePortfolioBO.getPrice().multiply(BigDecimal.valueOf(portfolio.getQuantity()));
            portfolio.setInvested(totalInvestment);
            portfolio.setUserId(portfolioServiceMapper.usersBOToUserEntity(updatePortfolioBO.getUsers()));
            portfolioEntitySaved = portfolioRepository.save(portfolio);
        }
        portfolioBO = portfolioServiceMapper.PortfolioEntityToPortfolioBO(portfolioEntitySaved);
        return portfolioBO;
    }


    private void sellStock(UpdatePortfolioBO updatePortfolioBO) {
        logger.info("sellStock: {}", updatePortfolioBO);
        Optional<PortfolioEntity> portfolioEntityOptional = portfolioRepository.findById(updatePortfolioBO.getSymbol());
        if(portfolioEntityOptional.isPresent()) {
            PortfolioEntity portfolio = portfolioEntityOptional.get();
            if(Objects.equals(portfolio.getQuantity(), updatePortfolioBO.getQuantity()))
            {
                portfolioRepository.delete(portfolio);
            }
            else {
                portfolio.setQuantity(portfolio.getQuantity() - updatePortfolioBO.getQuantity());
                BigDecimal investedTotal = portfolio.getInvested().subtract(updatePortfolioBO.getPrice().multiply(BigDecimal.valueOf(updatePortfolioBO.getQuantity())));
                portfolio.setInvested(investedTotal);
                 portfolioRepository.save(portfolio);
            }
        }
        else {
            throw new ServiceException("stock is not present in portfolio");
        }

    }


}
