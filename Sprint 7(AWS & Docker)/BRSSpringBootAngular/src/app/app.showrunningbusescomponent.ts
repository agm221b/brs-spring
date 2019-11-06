/* author Aditya
description : show buses component
Created on: 19/10/2019
Last modified on: 23/10/2019
 */
import { Component,OnInit} from '@angular/core'
import { BookingService } from './_service/app.bookingservice';
import { BusTransaction } from './_model/app.bustransaction';
import { BusService } from './_service/app.busservice';
import { ActivatedRoute, Router } from '@angular/router';
import { DatePipe } from '@angular/common';


@Component({
    selector:'searchrunningbuses',
    templateUrl: './_html/app.showrunningbuses.html'
})
export class ShowRunningBusesComponent implements OnInit{
    loadComponent=true;
    src:string;
    dest:string;
    journeydate:any;
    runningBuses:BusTransaction[]=[];
    dateFormat='dd-MM-yyyy';

    public popoverTitle: string = 'Book Ticket';
    public popoverMessage: string = 'Do you want to book your ticket in this bus?';
    public confirmClicked: boolean=false;
    public cancelClicked: boolean = false;

    constructor(private busService:BusService,private router:Router,private route:ActivatedRoute,private datepipe:DatePipe){}
    ngOnInit(){
        this.src=this.route.snapshot.paramMap.get("src");
        this.dest=this.route.snapshot.paramMap.get("dest");
        this.journeydate=this.route.snapshot.paramMap.get("journeydate");
        this.searchRunningBuses();
    }
    searchRunningBuses(){
        console.log("Hello");
        this.busService.showRunningBuses(this.src,this.dest,this.journeydate).subscribe((data:BusTransaction[])=>this.runningBuses=data);
        console.log(this.runningBuses);
    }
    addPassengerDetails(busTransactionId:number){
        this.router.navigate(['/addpassenger',busTransactionId]);
    }
    
}