export interface StockDataLatest {
  globalQuote: GlobalQuote
}

export interface GlobalQuote {
  symbol: string
  open: string
  high: string
  low: string
  price: string
  volume: string
  latestTradingDay: string
  previousClose: string
  change: string
  changePercent: string
}
