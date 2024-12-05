package com.bank.stock.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<PortfolioEntity, String> {

    List<PortfolioEntity> findByUserId_UserId(int id);
}
