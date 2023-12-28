import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Vendor} from "./vendor";

const apiRootUrl:string = "http://localhost:8080/api/inventory" ;
@Injectable({
  providedIn: 'root'
})
export class VendorDataService
{

  vendorUrl=apiRootUrl+"/vendor/"

  //inject the DI
  constructor(private http:HttpClient) { }

  //get all contact points
  getAllVendors():Observable<Vendor[]>{
    return this.http.get<Vendor[]>(this.vendorUrl);
  }

  //get contact by id
  getVendorById(id:number):Observable<Vendor>{
    return this.http.get<Vendor>(this.vendorUrl+id);
  }

  //create record
  createVendor(data:any ):Observable<any>{
    return this.http.post(this.vendorUrl,data).pipe();
  }
  //deleteById
  deleteVendorById(id:number){
    let myid=id;
    this.http.delete(this.vendorUrl+myid).subscribe(data=>{
      return this.getAllVendors();
    });
  }
  //update customer
  updateVendor(vendor:Vendor,id:number):Observable<any>{
    //return this.http.put(this.customerUrl+id,customer);
    return this.http.put(this.vendorUrl,vendor);
  }
}

