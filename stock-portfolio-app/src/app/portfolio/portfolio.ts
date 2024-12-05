import {user} from "./user";

export interface PortfolioData {
  portfolio: Portfolio[]
  totalPortfolio: number
  userId: user
}

export interface Portfolio {
  symbol: string
  quantity: number
  invested: string
  createdAt: string
  updatedAt: any
  price: number
  total: number
  change: number
}
