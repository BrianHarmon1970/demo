import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Vendor} from "../../vendor";
import {VendorDataService} from "../../vendor-data-service.service";

@Component({
  selector: 'app-vendor-create',
  templateUrl: './vendor-create.component.html',
  styleUrls: ['./vendor-create.component.css']
})
export class VendorCreateComponent implements OnInit
{
  vendor:Vendor = new Vendor() ;
  id:string|null = "" ;
  editForm!:FormGroup ;
  submitted:boolean=false;

  constructor(
    private service:VendorDataService,
    private activatedroute:ActivatedRoute,
    private builder:FormBuilder,
    private router:Router)
  {

  }

  ngOnInit(): void
  {
    this.id=this.activatedroute.snapshot.paramMap.get('id');
    console.log( "this.id = ", this.id ) ;
    //this.id = localStorage.getItem( "productId" ) ;
    this.service.getVendorById(Number(this.id)).subscribe( x=>this.vendor=x);

    this.editForm=this.builder.group({
      vendorName:['', Validators.required],
      vendorAddress:['',Validators.required],
      vendorPhone:['',Validators.required]
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
      this.service.createVendor(this.vendor).subscribe(
        x=>x=this.vendor=x ,
        () => { console.log("Error updating customer",this.vendor) ; },
        () => {
          console.log("Success updating vemdpr");
          console.log("vendor id - " + this.vendor.id + ": Changes updated" );
          let newroute: string = 'vendor' ;
          this.router.navigate([newroute]);
        }) ;
    }
  }
}
