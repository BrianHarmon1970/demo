import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppNavbarComponent } from './app-navbar/app-navbar.component';
import { AppCopyrightComponent } from './app-copyright/app-copyright.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {ContactListComponent} from "./inventory/contact-list/contact-list.component";

import { ContactEditComponent } from './inventory/contact-edit/contact-edit.component';
import { ContactCreateComponent } from './inventory/contact-create/contact-create.component';
import { VendorListComponent } from './inventory/vendor-list/vendor-list.component';
import { VendorEditComponent } from './inventory/vendor-edit/vendor-edit.component';
import { VendorCreateComponent } from './inventory/vendor-create/vendor-create.component';
import { CustomerListComponent } from './inventory/customer-list/customer-list.component';
import { CustomerEditComponent } from './inventory/customer-edit/customer-edit.component';
import { CustomerCreateComponent } from './inventory/customer-create/customer-create.component';
import {DataService} from "./data-service.service";
import {CustomerDataService} from "./customer-data-service.service";
import {VendorDataService} from "./vendor-data-service.service";

@NgModule({
  declarations: [
    AppComponent,
    AppNavbarComponent,
    AppCopyrightComponent,

    ContactListComponent,
    ContactEditComponent,
    ContactCreateComponent,

    VendorListComponent,
    VendorEditComponent,
    VendorCreateComponent,

    CustomerListComponent,
    CustomerEditComponent,
    CustomerCreateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule,
  ],
  providers: [
    DataService,
    CustomerDataService,
    VendorDataService
  ],
  exports: [
    ContactListComponent ,
    AppComponent,
    AppNavbarComponent,
    AppCopyrightComponent,
    RouterModule,
    AppRoutingModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
