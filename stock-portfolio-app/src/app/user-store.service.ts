import { Injectable } from '@angular/core';
import {user} from "./portfolio/user";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {StockSearch} from "./stock-search/stockSearch";

@Injectable({
  providedIn: 'root'
})
export class UserStoreService {

  user: user
  private apiUrl = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  getUser(): Observable<user>
  {
    let getUrl = this.apiUrl+ "portfolio/user?user=1";
    return this.http.get<user>(getUrl);
  }

}
