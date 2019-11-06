/* author Tejaswini
description : add booking component
Created on: 19/10/2019
Last modified on: 23/10/2019
 */
import { Component, OnInit} from '@angular/core'
import { BusService } from './_service/app.busservice';
import { Router, ActivatedRoute } from '@angular/router';
import { BookingService } from './_service/app.bookingservice';
import { BusTransaction } from './_model/app.bustransaction';
import { DatePipe } from '@angular/common';

@Component({
    selector: 'addbooking',
    templateUrl:'../app/_html/app.addbooking.html'
})
export class AddBookingComponent implements OnInit{
    sources:string[];
    destinations:string[];
    runningBuses:BusTransaction[]=[];
    src:string='';
    dest:string='';
    journeydate:any='';
    loadComponent=false;
    dateFormat='dd-MM-yyyy';

    minDate:any;
    maxDate:any;

    errorFlag:boolean=false;
    
    constructor(private busservice:BusService,private router:Router,private bookingService:BookingService,private route:ActivatedRoute,private datepipe:DatePipe){
        this.minDate=new Date();
        this.maxDate=new Date();
        this.maxDate.setMonth(this.maxDate.getMonth()+1);
    }

    ngOnInit(){
        this.busservice.getSources().subscribe((data:string[])=>this.sources=data);
        this.busservice.getDestinations().subscribe((data:string[])=>this.destinations=data);
    }

    searchRunningBuses(){
        if(this.src==='' && this.dest===''&& this.journeydate===null){
            alert('Please select source,destination and date of journey');
        }
        this.journeydate=this.datepipe.transform(this.journeydate,this.dateFormat);
        this.router.navigate(['/searchrunningbuses',this.src,this.dest,this.journeydate]);
    }

    bookingCheck(){
        if(this.src===this.dest){
            this.errorFlag=true;
        }else{
            this.errorFlag=false;
        }
    }

   
       

}