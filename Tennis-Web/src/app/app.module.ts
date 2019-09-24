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


import { dynamicReportComponenet } from './CompDynamicReport/dynamicReport.component';
import { AppDataService } from './service/AppData.service';
import { LoggingService } from './service/Logging.service'; 
import { AppData } from './model/AppData.model'; 

//import { ReportNameFilter } from './pipe/reportNameFilter.pipe';

// Add on Modules
import { AgGridModule } from 'ag-grid-angular';  
import { NgbTypeaheadModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AlertCompoenent } from './CompShared/CompAlert/alert.componenet';
import { ReportNameFilter } from './pipe/ReportNameFilter.pipe';
import { CustomSideBarComponenet } from './CompCustomSideBar/CustomSideBar.component';
import { MainPageComponenet } from './CompMainPage/MainPage.component';
import { MatchComponenet } from './CompMatch/Match.component';
import { MatchListComponenet } from './CompMatch/CompMatchList/MatchList.component';
import { MatchLatestComponenet } from './CompMatch/CompMatchLatest/MatchLatest.component';
import { TournamentComponenet } from './CompTournament/Tournament.componenet';
import { TournamentStandingComponenet } from './CompTournament/TournamentStanding/TournamentStanding.component';
import { HomePageComponenet } from './CompHomePage/HomePage.component';

 
@NgModule({ 
  declarations: [
    AppComponent
    ,headerComponenet
    ,dynamicReportComponenet
    ,AlertCompoenent
    ,CustomSideBarComponenet
    ,ReportNameFilter
    ,MainPageComponenet
    ,MatchComponenet
    ,MatchListComponenet
    ,MatchLatestComponenet
    ,TournamentComponenet
    ,TournamentStandingComponenet
    ,HomePageComponenet
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbTypeaheadModule,
    NgbModule,
    SidebarModule,
    AgGridModule.withComponents([])
    
  ],
  providers: [AppDataService,LoggingService],
  
  bootstrap: [AppComponent]
})
export class AppModule { }  
