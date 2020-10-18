import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { IniciocliComponent } from './iniciocli/iniciocli.component';
import { DataService } from "./dataBinding/data.service";


const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path:'iniciocli',
    component: IniciocliComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
