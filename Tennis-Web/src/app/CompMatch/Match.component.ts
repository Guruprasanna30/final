import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

import { AppData } from '../model/AppData.model'
import { AppDataService } from '../service/AppData.service';
import { LoggingService } from '../service/Logging.service'
@Component({
    selector: 'MatchSel',
    templateUrl:'./Match.component.html',
    providers: [LoggingService]
})
export class MatchComponenet implements OnInit{
    appData:AppData=AppData.Instance;    
    errorObj:any;
    columnDefs=[];
    rowData=[]; 
    
     
    constructor(private appDataService:AppDataService , private  loggingService:LoggingService){
        loggingService.log("inside MatchConstructor");
       
    }

    ngOnInit(){
        this.loggingService.log("Insie  match compoenent Init");
      
     }

      

 

      onHandleError() {
        this.errorObj = null;
      }
 
}