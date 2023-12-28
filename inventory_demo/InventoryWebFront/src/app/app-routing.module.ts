import { NgModule } from '@angular/core';
import {ContactListComponent} from "./inventory/contact-list/contact-list.component";
import {ContactEditComponent} from "./inventory/contact-edit/contact-edit.component";
import {ContactCreateComponent} from "./inventory/contact-create/contact-create.component";
import {CustomerListComponent} from "./inventory/customer-list/customer-list.component";
import {CustomerEditComponent} from "./inventory/customer-edit/customer-edit.component";
import {CustomerCreateComponent} from "./inventory/customer-create/customer-create.component";
import {VendorListComponent} from "./inventory/vendor-list/vendor-list.component";
import {VendorEditComponent} from "./inventory/vendor-edit/vendor-edit.component";
import {VendorCreateComponent} from "./inventory/vendor-create/vendor-create.component";
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [

  {path:"contact",component:ContactListComponent},
  {path:"contact-edit/:id", component:ContactEditComponent },
  {path:"contact-create", component:ContactCreateComponent },

  {path:"customer",component:CustomerListComponent},
  {path:"customer-edit/:id", component:CustomerEditComponent },
  {path:"customer-create", component:CustomerCreateComponent },

  {path:"vendor",component:VendorListComponent},
  {path:"vendor-edit/:id", component:VendorEditComponent },
  {path:"vendor-create", component:VendorCreateComponent }

  // {path:"",component:AppComponent}
  //{"path":"dashboard",component:DashboardComponent},
  //  {path:"**", component:DashboardComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
