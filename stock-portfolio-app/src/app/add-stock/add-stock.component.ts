import {ChangeDetectionStrategy, Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {StockService} from "../stock.service";
import {CompanyDetails} from "./companyDetails";
import {GlobalQuote} from "./stock-data-latest";
import {PortfolioService} from "../portfolio.service";
import {UpdatePortfolio} from "../portfolio/updatePortfolio";
import {AbstractControl, FormControl, FormGroup, ValidationErrors, Validators} from "@angular/forms";
import {UserStoreService} from "../user-store.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-add-stock', templateUrl: './add-stock.component.html', styleUrl: './add-stock.component.css'
})
export class AddStockComponent implements OnInit, OnChanges  {

  portfolioFormGroup = new FormGroup({
    quantity: new FormControl<any>(0, [Validators.required, this.validateQuantity.bind(this)])
  });
  @Input() stockName: string;

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['stockName'] && !changes['stockName'].isFirstChange()) {
      this.getStock(this.stockName);
    }
  }
  stockMetaData: GlobalQuote;
  companyDetails: CompanyDetails;
  loading: boolean = false;

  constructor(private stockService: StockService, private portfolioService: PortfolioService,
              private userStoreService: UserStoreService, private router: Router) {
}

  ngOnInit(): void {
    this.getStock(this.stockName)
  }

  getStock(name: string) {
    if (name) {
      let stockData = this.stockService.getStockDataLatest(name);
      let companyDetail = this.stockService.getCompanyOverview(name);

      companyDetail.subscribe(value => {
        this.companyDetails = value;
      });

      stockData.subscribe(value => {
        this.stockMetaData = value.globalQuote;
      });

    }

  }

  validateQuantity(ctrl: AbstractControl): ValidationErrors | null {
    const val = ctrl.value;
    console.log("val is " + val);
    if (!val || val === '' || val <= 0) {
      return {
        inValidQuantity: true
      }
    }
    return null;
  }

  buyStock() {
    this.loading = true;
    let updatePortfolio: UpdatePortfolio = {
      symbol: this.stockMetaData.symbol,
      quantity: this.portfolioFormGroup.value.quantity,
      price: this.stockMetaData.price,
      users: this.userStoreService.user,
      action: 'BUY'
    };
    console.log("added stock" + updatePortfolio)
    this.portfolioService.updatePortfolio(updatePortfolio).subscribe({
      next: response => {
        console.log('Portfolio updated successfully', response);
        this.loading = false;
      },
      error: err => console.error('Error updating portfolio', err)

    });

    this.router.navigate(['/portfolio']);
  }
}
