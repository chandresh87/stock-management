import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {RouterLink, RouterOutlet} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatInputModule} from '@angular/material/input';
import {AsyncPipe, NgForOf, NgStyle} from "@angular/common";
import {MatListItem, MatListModule, MatNavList} from "@angular/material/list";
import {MatIcon, MatIconModule} from "@angular/material/icon";
import {MatTableModule} from "@angular/material/table";
import {PortfolioComponent} from "./portfolio/portfolio.component";
import { StocksComponent } from './stocks/stocks.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import { StockSearchComponent } from './stock-search/stock-search.component';
import {HttpClientModule} from "@angular/common/http";
import {MatCardModule} from "@angular/material/card";
import {MatGridListModule} from "@angular/material/grid-list";
import {GridColsDirective} from "./gridCols.directive";
import { AddStockComponent } from './add-stock/add-stock.component';
import {MatDivider} from "@angular/material/divider";
import {MatDialogActions, MatDialogClose, MatDialogContent, MatDialogTitle} from "@angular/material/dialog";
import { SellStockComponent } from './sell-stock/sell-stock.component';
import {MatProgressSpinner} from "@angular/material/progress-spinner";
import { SpinnerComponentComponent } from './spinner-component/spinner-component.component';


@NgModule({
  declarations: [
    AppComponent,
    StocksComponent,
    PortfolioComponent,
    StockSearchComponent,
    GridColsDirective,
    AddStockComponent,
    SellStockComponent,
    SpinnerComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterOutlet,
    MatToolbarModule,
    FormsModule,
    ReactiveFormsModule,
    MatCheckboxModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule,
    MatSidenavModule,
    MatTableModule,
    MatCheckboxModule,
    NgStyle,
    MatNavList,
    RouterLink,
    MatIcon,
    NgForOf,
    BrowserAnimationsModule,
    MatListItem,
    FormsModule, MatAutocompleteModule, ReactiveFormsModule, AsyncPipe, HttpClientModule,
    MatCardModule,
    MatGridListModule, MatDivider, MatDialogContent, MatIconModule, MatListModule, MatDialogClose, MatDialogActions, MatDialogTitle, MatProgressSpinner
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
