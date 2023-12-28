import { Component, OnInit } from '@angular/core';
import {Contact} from "../../contact";
import {FormBuilder, FormGroup, Validator, Validators} from "@angular/forms";
import {DataService} from "../../data-service.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-contact-create',
  templateUrl: './contact-create.component.html',
  styleUrls: ['./contact-create.component.css']
})

export class ContactCreateComponent implements OnInit {
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
    this.editForm=this.builder.group({
      contactName:['', Validators.required],
      contactEmail:['', Validators.required],
      contactPhone:['', Validators.required]
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
      this.service.createContact(this.contact).subscribe(
        x=>x=this.contact=x ,
        () => { console.log("Error updating contact") ; },
        () => {
          console.log("Success updating contact");
          console.log("contact id - " + this.contact.id + ": Changes updated" );
          let newroute: string = 'contact' ;
          this.router.navigate([newroute]);
        }) ;
    }
  }
}
