import { Component, OnInit } from '@angular/core';
import {Vendor} from "../../vendor";
import {VendorDataService} from "../../vendor-data-service.service";

@Component({
  selector: 'app-vendor-list',
  templateUrl: './vendor-list.component.html',
  styleUrls: ['./vendor-list.component.css']
})

export class VendorListComponent implements OnInit
{
  constructor( private service:VendorDataService)
  {
  }
  vendors:Vendor[] = [] ;

  ngOnInit( ): void
  {
    this.service.getAllVendors().subscribe(result=>this.vendors=result);
  }

  deleteVendorById(id:number){
    //refresh the list once user is deleted
    this.vendors=this.vendors.filter(c=>c.id!=id);
    //delete user
    this.service.deleteVendorById(id);
    console.log("vendor deleted.");
  }
}
