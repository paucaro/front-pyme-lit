import { Component, OnInit } from '@angular/core';
import { IniciocliComponent } from '../iniciocli/iniciocli.component';
import { DataService } from "../dataBinding/data.service";

import {API} from 'aws-amplify'
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  message:string;
  constructor(private data: DataService) { }

  ngOnInit(): void {
    this.data.currentMessage.subscribe(message => this.message = message)

    component: IniciocliComponent;
  }
  getChuckFrase(){
    const path = '/chuck';
    const myInit = { // OPTIONAL
        headers: {  }, // OPTIONAL
        response: true, // OPTIONAL (return the entire Axios response object instead of only response.data)

    };
    const apiName = "chuckNorrisApi";
    API.get(apiName,path,myInit).then(response =>{
          console.log(response);
          this.message = response.data.value ;
          this.data.changeMessage(this.message)
      }).catch(error =>{

    })

}
}
