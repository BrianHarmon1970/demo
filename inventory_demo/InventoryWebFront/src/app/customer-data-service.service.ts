import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "./customer";

const apiRootUrl:string = "http://localhost:8080/api/inventory" ;

@Injectable({
  providedIn: 'root'
})
export class CustomerDataService
{

  customerUrl=apiRootUrl+"/customer/"

  //inject the DI
  constructor(private http:HttpClient) { }

  //get all contact points
  getAllCustomers():Observable<Customer[]>{
    return this.http.get<Customer[]>(this.customerUrl);
  }

  //get contact by id
  getCustomerById(id:number):Observable<Customer>{
    return this.http.get<Customer>(this.customerUrl+id);
  }

  //create record
  createCustomer(data:any ):Observable<any>{
    return this.http.post(this.customerUrl,data).pipe();
  }
  //deleteById
  deleteCustomerById(id:number){
    let myid=id;
    this.http.delete(this.customerUrl+myid).subscribe(data=>{
      return this.getAllCustomers();
    });
  }
  //update customer
  updateCustomer(customer:Customer,id:number):Observable<any>{
    //return this.http.put(this.customerUrl+id,customer);
    return this.http.put(this.customerUrl,customer);
  }
}

