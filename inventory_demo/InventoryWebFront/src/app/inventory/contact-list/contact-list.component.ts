import { Component, OnInit } from '@angular/core';
import {DataService} from "../../data-service.service";
import {Contact} from "../../contact";

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.css']
})

export class ContactListComponent implements OnInit
{
  constructor( private service:DataService) {     }
  contacts:Contact[] = [] ;

  ngOnInit( ): void {
   this.service.getAllContacts().subscribe(result=>this.contacts=result);

  }

  deleteContactById(id:number){
    //refresh the list once user is deleted
    this.contacts=this.contacts.filter(c=>c.id!=id);
    //delete user
    this.service.deleteContactById(id);
    console.log("contact deleted.");
  }
}
