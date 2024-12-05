package com.bank.stock.portfolio.api.models;

import lombok.Data;

@Data
public class UsersModel
{
	private int userId;
	private String name;
	private String address;
	private String emailId;
}