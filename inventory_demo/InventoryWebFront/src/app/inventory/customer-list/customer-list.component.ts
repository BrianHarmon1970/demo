import { Component, OnInit } from '@angular/core';
import {Customer} from "../../customer";
import {CustomerDataService} from "../../customer-data-service.service";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  constructor( private service:CustomerDataService) {     }
  customers:Customer[] = [] ;

  ngOnInit( ): void {
    this.service.getAllCustomers().subscribe(result=>this.customers=result);

  }
  deleteCustomerById(id:number){
    //refresh the list once user is deleted
    this.customers=this.customers.filter(c=>c.id!=id);
    //delete user
    this.service.deleteCustomerById(id);
    console.log("contact deleted.");
  }
}
