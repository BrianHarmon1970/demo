import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Vendor} from "../../vendor";
import {VendorDataService} from "../../vendor-data-service.service";

@Component({
  selector: 'app-vendor-edit',
  templateUrl: './vendor-edit.component.html',
  styleUrls: ['./vendor-edit.component.css']
})

export class VendorEditComponent implements OnInit
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
      this.service.updateVendor(this.vendor,Number(this.id)).subscribe(
        x=>x=this.vendor=x ,
        () => { console.log("Error updating vendor",this.vendor) ; },
        () => {
          console.log("Success updating vendor");
          console.log("vendor id - " + this.vendor.id + ": Changes updated" );
          let newroute: string = 'vendor' ;
          this.router.navigate([newroute]);
        }) ;
    }
  }
}
