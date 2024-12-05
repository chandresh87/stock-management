import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {StockSearch} from "./stock-search/stockSearch";
import {MarketInsight} from "./stocks/marketInsight";
import {CompanyDetails} from "./add-stock/companyDetails";
import {StockDataLatest} from "./add-stock/stock-data-latest";

@Injectable({
  providedIn: 'root'
})
export class StockService {

  private apiUrl = 'http://localhost:8080/';

  constructor(private http: HttpClient) {
  }

  searchStock(name: string): Observable<StockSearch> {
    let getUrl = this.apiUrl + "stock/search?symbol=" + name;
    return this.http.get<StockSearch>(getUrl);
  }

  marketInsight(): Observable<MarketInsight> {
    let getUrl = this.apiUrl + "insight";
    return this.http.get<MarketInsight>(getUrl);
  }

  getStockDataLatest(name: string): Observable<StockDataLatest> {

    let getUrl = this.apiUrl + "stock?symbol=" + name;

    return this.http.get<StockDataLatest>(getUrl);
  }

  getCompanyOverview(name: string): Observable<CompanyDetails> {
    let getUrl = this.apiUrl + "company/detail?symbol=" + name;
    return this.http.get<CompanyDetails>(getUrl);
  }
}
