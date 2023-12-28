import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Data, Router} from "@angular/router";
import {Contact} from "../../contact";
import {DataService} from "../../data-service.service";

@Component({
  selector: 'app-contact-edit',
  templateUrl: './contact-edit.component.html',
  styleUrls: ['./contact-edit.component.css']
})

export class ContactEditComponent implements OnInit
{
  contact:Contact = new Contact() ;
  id:string|null = "" ;
  editForm!:FormGroup ;
  submitted:boolean=false;

  constructor(
    private service:DataService,
    private activatedroute:ActivatedRoute,
    private builder:FormBuilder,
    private router:Router)
  {
  }

  ngOnInit(): void
  {
    this.id=this.activatedroute.snapshot.paramMap.get('id');
    console.log( "this.id = ", this.id ) ;
    this.service.getContactById(Number(this.id)).subscribe( x=>this.contact=x);

    this.editForm=this.builder.group({
      contactName:['', Validators.required],
      contactEmail:['',Validators.required],
      contactPhone:['',Validators.required]
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
      this.service.updateContact(this.contact,Number(this.id)).subscribe(
        x=>x=this.contact=x ,
        () => { console.log("Error updating product") ; },
        () => {
          console.log("Success updating contact");
          console.log("contact id - " + this.contact.id + ": Changes updated" );
          let newroute: string = 'contact' ;
          this.router.navigate([newroute]);
        }) ;
    }
  }
}
