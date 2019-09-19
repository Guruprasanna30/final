import { Component } from '@angular/core';
import { AppData } from './model/AppData.model';
import { Constant } from './model/Constant.model';




@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  appData:AppData=AppData.Instance;
  constant:Constant=Constant.Instance;




}
