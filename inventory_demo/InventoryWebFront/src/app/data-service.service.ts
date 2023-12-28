import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Contact } from './contact';

const apiRootUrl:string = "http://localhost:8080/api/inventory" ;

@Injectable({
  providedIn: 'root'
})
export class DataService
{
  contactUrl=apiRootUrl+"/contact/"

  //inject the DI
  constructor(private http:HttpClient) { }

  //get all contact points
  getAllContacts():Observable<Contact[]>{
    return this.http.get<Contact[]>(this.contactUrl);
  }

  //get contact by id
  getContactById(id:number):Observable<Contact>{
    return this.http.get<Contact>(this.contactUrl+id);
  }

  //create record
  createContact(data:any ):Observable<any>{
    return this.http.post(this.contactUrl,data).pipe();
  }
  //deleteById
  deleteContactById(id:number){
    let myid=id;
    this.http.delete(this.contactUrl+myid).subscribe(data=>{
      return this.getAllContacts();
    });
  }
  //update contact
  updateContact(contact:Contact,id:number):Observable<any>{
    return this.http.put(this.contactUrl+id,contact);
  }
}
