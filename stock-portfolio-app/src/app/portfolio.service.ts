import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Stock} from "./portfolio/stock";
import {Observable, of} from 'rxjs';
import {PortfolioData} from "./portfolio/portfolio";
import {StockData} from "./add-stock/stock-data";
import {user} from "./portfolio/user";
import {UpdatePortfolio} from "./portfolio/updatePortfolio";

@Injectable({
  providedIn: 'root'
})
export class PortfolioService {

  private apiUrl = 'http://localhost:8080/';
  user: user;
  constructor(private http: HttpClient) { }

  getPortfolio():Observable<PortfolioData>
  {
    let getUrl = this.apiUrl+ "portfolio/get?user=1";

    return this.http.get<PortfolioData>(getUrl);
  }

  updatePortfolio(updatePortfolio: UpdatePortfolio): Observable<any>
  {
    return this.http.post <UpdatePortfolio> (this.apiUrl+"portfolio/update", updatePortfolio);
  }
}
