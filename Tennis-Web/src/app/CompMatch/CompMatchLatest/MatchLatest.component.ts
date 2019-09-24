import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

import { AppData } from '../../model/AppData.model';
import { AppDataService } from '../../service/AppData.service';
import { LoggingService } from '../../service/Logging.service';
@Component({
    selector: 'MatchLatestSel',
    templateUrl:'./MatchLatest.component.html',
    providers: [LoggingService]
})
export class MatchLatestComponenet implements OnInit{
    appData:AppData=AppData.Instance;

    ngOnInit(){
        this.loggingService.log("Insie  Match Latest compoenent Init");
     }

     constructor(private appDataService:AppDataService , private  loggingService:LoggingService){
        loggingService.log("inside Match Latest Constructor");
       
    }

}