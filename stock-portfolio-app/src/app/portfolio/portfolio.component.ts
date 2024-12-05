import {Component, inject, OnInit} from '@angular/core';
import {SelectionModel} from '@angular/cdk/collections';
import {MatTableDataSource} from '@angular/material/table';
import {Stock} from "./stock";
import {PortfolioService} from "../portfolio.service";
import {Portfolio, PortfolioData} from "./portfolio";
import {MatDialog} from "@angular/material/dialog";
import {SellStockComponent} from "../sell-stock/sell-stock.component";
import {UserStoreService} from "../user-store.service";


@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrl: './portfolio.component.css'
})
export class PortfolioComponent implements  OnInit{

  profileStockList: Portfolio[];
  totalPortfolio: number;
  dialog = inject(MatDialog);

  displayedColumns: string[] = ['select', 'symbol', 'price', 'quantity' , 'total'];

  dataSource : MatTableDataSource<Portfolio>;
  selection = new SelectionModel<Portfolio>(false, []);
  numRows: number | undefined;
  loading: boolean = false;

  constructor(private portfolioService: PortfolioService) {
  }
  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    return numSelected === this.numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  toggleAllRows() {
    if (this.isAllSelected()) {
      this.selection.clear();
      return;
    }

    this.selection.select(...this.dataSource.data);
  }

  /** The label for the checkbox on the passed row */
  checkboxLabel(row?: Portfolio): string {
    if (!row) {
      return `${this.isAllSelected() ? 'deselect' : 'select'} all`;
    }
    //return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.position + 1}`;
    return "";
  }

  ngOnInit(): void {
    this.loading = true;
    this.getPortfolioData();

  }

  private getPortfolioData() {
    this.portfolioService.getPortfolio().subscribe(value => {
      this.totalPortfolio = value.totalPortfolio;
      this.profileStockList = value.portfolio;
      this.dataSource = new MatTableDataSource<Portfolio>(this.profileStockList);
      this.numRows = this.dataSource.data.length;
      this.loading = false;
    });
  }

  openDialog(row:Portfolio) {
    console.log("row is "+row.symbol);
    this.dialog.open(SellStockComponent, {
      data: {
        row
      },
    }).afterClosed().subscribe(value => {
      console.log("Closed"+ value);
      this.getPortfolioData()
    })
  }
}
