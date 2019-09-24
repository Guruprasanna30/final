import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

import { AppData } from '../../model/AppData.model';
import { AppDataService } from '../../service/AppData.service';
import { LoggingService } from '../../service/Logging.service';
@Component({
    selector: 'MatchListSel',
    templateUrl:'./MatchList.component.html',
    providers: [LoggingService]
})
export class MatchListComponenet implements OnInit{
    appData:AppData=AppData.Instance;
    errorObj:any;
    columnDefs=[];
    rowData=[]; 

    ngOnInit(){
        this.loggingService.log("Insie  Match List compoenent Init");  
        this.getMatchList();

     } 

     constructor(private appDataService:AppDataService , private  loggingService:LoggingService){
        loggingService.log("inside Match List Constructor");
       
    } 

    getMatchList(){
        this.appDataService.getMatchList().subscribe(responseData=>{
          console.log("The report data is",responseData);
          this.columnDefs=responseData[0];
          this.rowData=responseData[1];          
      },error =>{
        this.errorObj=error;
       // this.errorObj={"message":  error.error.message,"status":  error.status,"statusText":  error.statusText,"serviceUrl":  error.url}
            this.loggingService.log( this.errorObj.error.message);           
      });;
      }

      onHandleError() {
        this.errorObj = null;
      }  
          

}