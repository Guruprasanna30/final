import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

import { AppData } from '../model/AppData.model'
import { AppDataService } from '../service/AppData.service';
import { LoggingService } from '../service/Logging.service'
@Component({
    selector: 'TournamentSel',
    templateUrl:'./Tournament.component.html',
    providers: [LoggingService]
})
export class TournamentComponenet implements OnInit{
    appData:AppData=AppData.Instance;       
    errorObj:any;
    columnDefs=[];
    rowData=[]; 
    
     
    constructor(private appDataService:AppDataService , private  loggingService:LoggingService){ 
        loggingService.log("inside tournament Constructor");
       
    }

    ngOnInit(){
        this.loggingService.log("Insie  tournament compoenent Init "); 
      
     }


      onHandleError() {
        this.errorObj = null;
      }
 
}