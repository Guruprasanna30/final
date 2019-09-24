import { Injectable } from '@angular/core';

@Injectable()  
export  class Constant{

    public  APPLICATION_TITLE:string="Play My Tennis";
    public  VIEW_HOME:string="viewHome";
    public  VIEW_MATCH:string="viewMatch";
    public  VIEW_TOURNAMENT:string="viewTournament";
    public  VIEW_DYNAMIC_REPORT:string="viewDynamicReport";

    public EMPTY:string="";

    public SERVER_IP:string="localhost"; 
    public SERVER_PORT:string="8080";
    public SERVER_PROTOCOL:string="http";
    public APP_CONTEXT:string="tennis";
    public DEFAULT_DATABASEs:string="DBTENNIS"; 

    public  URL_ADD_REPORT:string="https://ng-complete-guide-c56d3.firebaseio.com/posts.json"; 
    public  URL_BASE:string= this.SERVER_PROTOCOL+"://"+this.SERVER_IP+":"+this.SERVER_PORT+"/";//+  this.APP_CONTEXT+"/";
   // public  URL_BASE:string= "/"; 
    public  URL_GET_MESSAGE:string= this.URL_BASE +"message"; 
    public  URL_GET_MATCH_LIST:string=this.URL_BASE +"displayMatchList";
    public  URL_GET_TOURNAMENT_STANDING:string=this.URL_BASE +"displayTournamentStanding";
    public  URL_GET_DYNAMIC_REPORT:string=this.URL_BASE+"dynamicReport";
    public  URL_GET_MEDIA_IMG_BY_TOURNAMENT:string=this.URL_BASE+="mediaImagesForTournament";
  

    public  ERR_MESSAGE_NOT_AVAILABLE:string="Error message not availble";
    public  ERR_SERVER_NOT_AVAILABLE:string="The Serive may not be available"; 

    

    private static constant: Constant;
    private constructor(){        
    }

    public static get Instance()
    {               
        return this.constant || (this.constant = new this());        
    }

}