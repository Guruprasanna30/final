import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

import { AppData } from '../../model/AppData.model'
import { AppDataService } from '../../service/AppData.service';
import { LoggingService } from '../../service/Logging.service'
import { AgGridAngular } from 'ag-grid-angular';
import { GridOptions } from 'ag-grid-community';


@Component({
    selector: 'TournamentStandingSel',
    templateUrl:'./TournamentStanding.component.html',
    providers: [LoggingService]
})
export class TournamentStandingComponenet implements OnInit{

  @ViewChild('myGrid', { static: false }) myGrid: AgGridAngular;
    appData:AppData=AppData.Instance;       
    errorObj:any;
    columnDefs=[];
    rowData=[]; 
    public defaultColDef;
     private gridApi;
  private gridColumnApi

    
    
     
    constructor(private appDataService:AppDataService , private  loggingService:LoggingService){ 
        loggingService.log("inside TournamentStanding Constructor");
        this.defaultColDef = { resizable: true };

       
    }

    ngOnInit(){
        this.loggingService.log("Insie  Tournament Standing compoenent Init ");         
        this.getTournamentStanding();       
     }

     getTournamentStanding(){
        this.appDataService.getTournamentStanding("1").subscribe(responseData=>{ 
          console.log("The report data is",responseData);

          this.columnDefs=responseData[0];
          this.rowData=responseData[1];     
         
          
      },error =>{
        this.errorObj=error;
       // this.errorObj={"message":  error.error.message,"status":  error.status,"statusText":  error.statusText,"serviceUrl":  error.url}
            this.loggingService.log( this.errorObj.error.message);           
      });;
      }

      pinfields(){
        this.loggingService.log("Inside pin fields");

        this.gridColumnApi.setColumnPinned("Ranking", "left");
       
      }

      sizeToFit() {
        this.gridApi.sizeColumnsToFit();
      }



      onHandleError() {
        this.errorObj = null;
      }

      onGridReady(params) {
        this.gridApi = params.api;
        this.gridColumnApi = params.columnApi;
      }
 
}