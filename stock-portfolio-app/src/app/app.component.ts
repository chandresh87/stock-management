import {Component, OnInit} from '@angular/core';
import {routes} from "./app-routing.module";
import {UserStoreService} from "./user-store.service";
import {user} from "./portfolio/user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'stock-portfolio-app';
  routes = routes;
  userName : String = '';
  constructor(private userStoreService: UserStoreService) { }

  ngOnInit(): void {
    this.userStoreService.getUser().subscribe(value => {
      this.userStoreService.user = value;
      this.userName = value.name
    })
    }
}
