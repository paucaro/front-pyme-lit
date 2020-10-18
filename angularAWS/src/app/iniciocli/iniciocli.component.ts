import { Component, OnInit , Input   } from '@angular/core';
import { DataService } from "../dataBinding/data.service";
@Component({
  selector: 'app-iniciocli',
  templateUrl: './iniciocli.component.html',
  styleUrls: ['./iniciocli.component.scss']

})
export class IniciocliComponent implements OnInit {

  constructor(private data: DataService) { }
  joke :string ;

  ngOnInit(): void
   {

    this.data.currentMessage.subscribe(message => this.joke = message)
  }


}
