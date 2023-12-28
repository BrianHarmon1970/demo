import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

import {ActivatedRoute, Router} from "@angular/router";
import {Customer} from "../../customer";
import {CustomerDataService} from "../../customer-data-service.service";

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  customer:Customer = new Customer() ;
  id:string|null = "" ;
  editForm!:FormGroup ;
  submitted:boolean=false;

  constructor(
    private service:CustomerDataService,
    private activatedroute:ActivatedRoute,
    private builder:FormBuilder,
    private router:Router)
  {

  }

  ngOnInit(): void {

    this.id=this.activatedroute.snapshot.paramMap.get('id');
    console.log( "this.id = ", this.id ) ;
    this.service.getCustomerById(Number(this.id)).subscribe( x=>this.customer=x);

    this.editForm=this.builder.group({
      customerName:['', Validators.required],
      customerAddress:['',Validators.required],
      customerPhone:['',Validators.required]
    });
  }

  get form(){
    return this.editForm.controls;
  }

  onSubmit(){
    this.submitted=true;
    if(this.editForm.invalid)
      return;
    else
    {
      console.log( "id - " + this.id + ": Submitting changes" ) ;
      this.service.updateCustomer(this.customer,Number(this.id)).subscribe(
        x=>x=this.customer=x ,
        () => { console.log("Error updating customer",this.customer) ; },
        () => {
          console.log("Success updating customer");
          console.log("customer id - " + this.customer.id + ": Changes updated" );
          let newroute: string = 'customer' ;
          this.router.navigate([newroute]);
        }) ;
    }
  }
}
