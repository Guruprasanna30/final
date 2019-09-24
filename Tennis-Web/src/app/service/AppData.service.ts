import { AppData } from '../model/AppData.model'
import { EventEmitter } from 'events';
import { HttpClient, HttpParams } from '@angular/common/http';
import { LoggingService } from './Logging.service';
import { Injectable } from '@angular/core';
import { Constant } from '../model/Constant.model';
import {catchError, debounceTime, distinctUntilChanged, map, tap, switchMap} from 'rxjs/operators';
import {Observable, of} from 'rxjs';



@Injectable()
export class AppDataService {

    //appDataChanged = new EventEmitter<AppData>();
    private appData:AppData = AppData.Instance;
    private constant:Constant=Constant.Instance;
    constructor(private http:HttpClient,
                private logService:LoggingService
                ){

    }
    
  

    getMatchList(){
        return this.http.get(this.constant.URL_GET_MATCH_LIST);        
    }

    getTournamentStanding( tournamentId:string){
        let data = {"tournamentId": tournamentId};
        return this.http.get(this.constant.URL_GET_TOURNAMENT_STANDING,{params: data});        
    } 

    getConnectionList(){        
        return this.http.get(this.constant.URL_GET_TOURNAMENT_STANDING);
    }

    getMediaImgListByTournament(tournamentId:string){        
        let data = {"tournamentId": tournamentId};

        return this.http.get(this.constant.URL_GET_MEDIA_IMG_BY_TOURNAMENT,{params: data});
    }
    

    runDynamicReport(dynamicReportSQL:string,selectedConnection:string){
        let data = {"dynamicReportSQL": dynamicReportSQL,"selectedConnection": selectedConnection};
        return this.http.get(this.constant.URL_GET_DYNAMIC_REPORT,{params: data})        
    }

   /* runStaticReport(reportIdentifier:string , filter:any){
        let data = {"reportIdentifier": reportIdentifier  , "filter":filter};
        console.log( "the data sent to the server is ",data);
         return this.http.post(this.constant.URL_GET_STATIC_REPORT,data,{params: data});
        //return this.http.get(this.constant.URL_GET_STATIC_REPORT,{params: data})
    }*/



    searchReports(searchTerm: string) {
        let data = {"searchTerm": searchTerm};
        if (searchTerm === '') {
          return of([]);
        }
    
        return this.http
          .get(this.constant.URL_GET_MATCH_LIST, {params: data}); 
      }
    
}