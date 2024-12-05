import {Component, OnInit} from '@angular/core';
import {StockService} from "../stock.service";
import {TopGainerLooser} from "./marketInsight";

@Component({
  selector: 'app-stocks', templateUrl: './stocks.component.html', styleUrl: './stocks.component.css'
})
export class StocksComponent implements OnInit {

  selectedStockSymbol: string;
  showAddComponent: boolean;
  topGainers: TopGainerLooser[];
  topLosers: TopGainerLooser[];
  mostActivelyTraded: TopGainerLooser[];


  constructor(private stockService: StockService) {
  }

  ngOnInit() {
    this.stockService.marketInsight().subscribe(response => {
      this.topGainers = response.topGainers;
      this.topLosers = response.topLosers;
      this.mostActivelyTraded = response.mostActivelyTraded;
    });
  }


  addStock(symbol: string) {
    this.selectedStockSymbol = symbol;
    this.showAddComponent = !!symbol;

  }
}
