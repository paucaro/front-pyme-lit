import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

/* import AmplifyUIAngularModule  */
import { AmplifyUIAngularModule } from '@aws-amplify/ui-angular';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { IniciocliComponent } from './iniciocli/iniciocli.component';
import { DataService } from "./dataBinding/data.service";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    IniciocliComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    /* configure app with AmplifyUIAngularModule */
    AmplifyUIAngularModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [  DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
