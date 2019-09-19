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

    loadedFeature=this.constant.VIEW_REPORT;
  
    onNavigate(feature:string){
      console.log(this.loadedFeature);
      this.loadedFeature=feature; 
    }
     
    constructor(private appDataService:AppDataService , private  loggingService:LoggingService){
        loggingService.log("inside create report Constructor");
       
    }

    ngOnInit(){
        this.loggingService.log(this.appData.reportlist);
        this.loggingService.log(this.appDataService.getReportName);
        
        console.log(this.appData.reportlist);
     }

     onAddReport() {    
        var reportName = this.nameInputRef.nativeElement.value;
        this.appDataService.addReportName(reportName);
        this.loggingService.log("inside createReport" + this.appData.reportlist);      
      }
      onDeleteReport(){
        //this.appDataService.addReport({"name":"Report1", "sql":"test"});
      }

      onGetMessage(){
        this.appDataService.getmessage().subscribe(responseData=>{
          console.log("The report data is",responseData);          
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