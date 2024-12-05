import {Component, inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {Portfolio} from "../portfolio/portfolio";
import {UserStoreService} from "../user-store.service";
import {UpdatePortfolio} from "../portfolio/updatePortfolio";
import {PortfolioService} from "../portfolio.service";
import {AbstractControl, FormControl, FormGroup, ValidationErrors, Validators} from "@angular/forms";


@Component({
  selector: 'app-sell-stock',
  templateUrl: './sell-stock.component.html',
  styleUrl: './sell-stock.component.css'
})
export class SellStockComponent {

  data = inject(MAT_DIALOG_DATA);
  portfolioFormGroup =new FormGroup({
    quantity: new FormControl<any>(0, [Validators.required, this.validateQuantity.bind(this)])});

  constructor(private userStoreService: UserStoreService, private portfolioService: PortfolioService) {
  }



  validateQuantity(ctrl: AbstractControl): ValidationErrors | null {
    const val = ctrl.value;
    console.log("val is "+val);
    if (!val || val === '' || val <= 0 || val > this.data.row.quantity) {
      return {
        inValidQuantity: true
      }
    }
    return null;
  }

  sellStock()
  {

    let updatePortfolio: UpdatePortfolio = {
      symbol: this.data.row.symbol,
      quantity: this.portfolioFormGroup.value.quantity,
      price: this.data.row.price,
      users: this.userStoreService.user,
      action: this.data.row.action
    };
    console.log("updatePortfolio is "+updatePortfolio);
    this.portfolioService.updatePortfolio(updatePortfolio).subscribe({
      next: response => console.log('Portfolio updated successfully', response),
      error: err => console.error('Error updating portfolio', err)
    });

  }
}
