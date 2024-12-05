export interface MarketInsight {
  metadata: string
  lastUpdated: string
  topGainers: TopGainerLooser[]
  topLosers: TopGainerLooser[]
  mostActivelyTraded: TopGainerLooser[]
}

export interface TopGainerLooser {
  ticker: string
  price: string
  changeAmount: string
  changePercentage: string
  volume: string
}


