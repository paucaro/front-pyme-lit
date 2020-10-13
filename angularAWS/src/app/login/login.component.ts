import { Component, OnInit } from '@angular/core';
import { IniciocliComponent } from '../iniciocli/iniciocli.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    component: IniciocliComponent
  }

}
