import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import {Router,RouterModule,RouterLink} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './app-navbar.component.html',
  styleUrls: ['./app-navbar.component.css']
})
export class AppNavbarComponent implements OnInit {

  parent:AppComponent ;

  constructor(app:AppComponent )
  {
    this.parent = app ;
  }

  ngOnInit(): void {
  //  parent.router.navigate(['contact']) ;


  }
  setContext(): void
  {
    //this.parent.navContext = "main" ;
  }

}
