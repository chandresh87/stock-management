package com.bank.stock.portfolio.service.bos;

import com.bank.stock.portfolio.repository.PortfolioEntity;
import lombok.Data;

@Data
public class UsersBO
{
	private int userId;
	private String name;
	private String address;
	private String emailId;
}