export interface StockSearch {
  bestMatches: BestMatch[]
}

export interface BestMatch {
  symbol: string
  name: string
  type: string
  region: string
  marketOpen: string
  marketClose: string
  timezone: string
  currency: string
  matchScore: string
}
