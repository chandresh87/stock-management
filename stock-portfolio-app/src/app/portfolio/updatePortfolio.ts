import {user} from "./user";

export interface UpdatePortfolio {
  symbol: string
  quantity: string
  price: string
  users: user
  action: string
}

