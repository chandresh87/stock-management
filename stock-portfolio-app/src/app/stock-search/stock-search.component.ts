import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {FormControl} from "@angular/forms";
import {Observable} from "rxjs";
import {StockService} from "../stock.service";

@Component({
  selector: 'app-stock-search',
  templateUrl: './stock-search.component.html',
  styleUrl: './stock-search.component.css'
})
export class StockSearchComponent implements OnChanges {

  constructor(private stockService: StockService) {
  }
  stockNames: string[] =[];
  control = new FormControl('');

  @Output() stockSymbolEvent = new EventEmitter<string>();

  ngOnChanges(changes: SimpleChanges): void {
    console.log("entered symbol is "+ changes['stocksymbol'].currentValue)
  }

  searchString(event: Event)
  {
    const newValue = (event.target as HTMLInputElement).value;
    console.log("entered symbol is "+newValue);

    if(!newValue)
    {this.stockNames =[];
      this.stockSymbolEvent.emit(newValue);
    }
    //To minimize the network call, we are searching for symbol string >=2
    else if(newValue.length >=2){
      this.stockService.searchStock(newValue).subscribe(
        (response) => {
          this.stockNames = response.bestMatches.map(value => value["symbol"])

        });
    }


  }

  handleSelectedStock(stockSymbol:string)
  {
    console.log("selected stock symbol"+ stockSymbol);
    this.stockSymbolEvent.emit(stockSymbol);
  }
}
