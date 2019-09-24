import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { NgbCarousel, NgbSlideEvent, NgbSlideEventSource } from '@ng-bootstrap/ng-bootstrap';


import { AppData } from '../model/AppData.model';
import { AppDataService } from '../service/AppData.service';
import { LoggingService } from '../service/Logging.service';
@Component({
    selector: 'HomePageSel',
    templateUrl:'./HomePage.component.html',
    providers: [LoggingService]
})
export class HomePageComponenet implements OnInit{
    appData:AppData=AppData.Instance;
    errorObj:any;
    mediaImgList:any;

    ngOnInit(){
        this.loggingService.log("Insie  Home Page compoenent Init");
        this.getMediaImgListByTournament();
     }

     constructor(private appDataService:AppDataService , private  loggingService:LoggingService){
        loggingService.log("inside Home Page Constructor");
       
    }

    images = [1, 2, 3, 4, 5, 6, 7].map(() => `https://picsum.photos/900/500?random&t=${Math.random()}`);
    @ViewChild('carousel', {static : true}) carousel: NgbCarousel;


    getMediaImgListByTournament(){
      this.appDataService.getMediaImgListByTournament("1").subscribe(responseData=>{
        this.mediaImgList=responseData;
        console.log("The report data is",responseData);
                 
    },error =>{
      this.errorObj=error;
     // this.errorObj={"message":  error.error.message,"status":  error.status,"statusText":  error.statusText,"serviceUrl":  error.url}
          this.loggingService.log( this.errorObj.error.message);           
    });;
    }

    paused = false;
  unpauseOnArrow = false;
  pauseOnIndicator = false;
  pauseOnHover = true;

    togglePaused() {
        if (this.paused) {
          this.carousel.cycle();
        } else {
          this.carousel.pause();
        }
        this.paused = !this.paused;
      }
    
      onSlide(slideEvent: NgbSlideEvent) {
        if (this.unpauseOnArrow && slideEvent.paused &&
          (slideEvent.source === NgbSlideEventSource.ARROW_LEFT || slideEvent.source === NgbSlideEventSource.ARROW_RIGHT)) {
          this.togglePaused();
        }
        if (this.pauseOnIndicator && !slideEvent.paused && slideEvent.source === NgbSlideEventSource.INDICATOR) {
          this.togglePaused();
        }
      }

}