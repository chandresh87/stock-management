import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PortfolioComponent} from "./portfolio/portfolio.component";
import {StocksComponent} from "./stocks/stocks.component";



export const routes: Routes = [
  {path: 'portfolio', component: PortfolioComponent, title: 'Portfolio'},
  {path: 'stocks', component: StocksComponent, title: 'Stocks'},
  {
    path: '',
    redirectTo: '/portfolio',
    pathMatch: 'full'
  },
  {
    path: '**',
    redirectTo: '/portfolio',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
