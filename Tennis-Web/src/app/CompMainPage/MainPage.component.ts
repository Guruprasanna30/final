import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

import { AppData } from '../model/AppData.model'
import { AppDataService } from '../service/AppData.service';
import { LoggingService } from '../service/Logging.service'
import { Constant } from '../model/Constant.model';
@Component({
    selector: 'MainPageSel',
    templateUrl:'./MainPage.component.html',
    providers: [LoggingService]
})
export class MainPageComponenet implements OnInit{
    appData:AppData=AppData.Instance;
    constant:Constant=Constant.Instance;
    reportList:Array<string>;
    errorObj:any;
    @ViewChild('nameInput', { static: false }) nameInputRef: ElementRef;

    
    

    title = this.constant.APPLICATION_TITLE;

    loadedFeature=this.constant.VIEW_MATCH;
  
    onNavigate(feature:string){
      console.log(this.loadedFeature);
      this.appData.loadedFeature=feature; 
    }
     
    constructor(private appDataService:AppDataService , private  loggingService:LoggingService){
        loggingService.log("inside create report Constructor");
       
    }

    ngOnInit(){
        this.loggingService.log("Inside Main page on Init");
        this.appData.loadedFeature=this.constant.VIEW_HOME;

     }





      onHandleError() {
        this.errorObj = null;
      }
 
}