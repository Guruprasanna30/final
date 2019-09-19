// Angular Base Modules
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { SidebarModule } from 'ng-sidebar';  

// Appl;cation Module
import { AppComponent } from './app.component';
import { headerComponenet } from './CompHeader/header.component';
import { viewReportComponenet } from './CompViewReport/viewReport.component';
import { createReportComponenet } from './CompCreateReport/createReport.component';
import { dynamicReportComponenet } from './CompDynamicReport/dynamicReport.component';
import { AppDataService } from './service/AppData.service';
import { LoggingService } from './service/Logging.service'; 
import { AppData } from './model/AppData.model'; 

//import { ReportNameFilter } from './pipe/reportNameFilter.pipe';

// Add on Modules
import { AgGridModule } from 'ag-grid-angular';  
import { NgbTypeaheadModule } from '@ng-bootstrap/ng-bootstrap';
import { QueryBuilderModule } from "angular2-query-builder";
import { sqlBuilderComponenet } from './CompSqlBuilder/sqlBuilder.component';
import { AlertCompoenent } from './CompShared/CompAlert/alert.componenet';
import { ReportNameFilter } from './pipe/ReportNameFilter.pipe';
import { CustomSideBarComponenet } from './CompCustomSideBar/CustomSideBar.component';
import { MainPageComponenet } from './CompMainPage/MainPage.component';


@NgModule({ 
  declarations: [
    AppComponent
    ,headerComponenet
    ,viewReportComponenet
    ,createReportComponenet
    ,dynamicReportComponenet
    ,sqlBuilderComponenet
    ,AlertCompoenent
    ,CustomSideBarComponenet
    ,ReportNameFilter
    ,MainPageComponenet
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbTypeaheadModule,
    QueryBuilderModule,
    SidebarModule,
    AgGridModule.withComponents([])
    
  ],
  providers: [AppDataService,LoggingService],
  
  bootstrap: [AppComponent]
})
export class AppModule { }  
