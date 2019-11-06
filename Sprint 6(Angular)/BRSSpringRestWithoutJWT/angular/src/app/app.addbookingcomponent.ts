import { Component, OnInit} from '@angular/core'
import { BusService } from './_service/app.busservice';
import { Router } from '@angular/router';
import { BookingService } from './_service/app.bookingservice';
import { BusTransaction } from './_model/app.bustransaction';

@Component({
    selector: 'addbooking',
    templateUrl:'../app/_html/app.addbooking.html'
})
export class AddBookingComponent implements OnInit{
    sources:string[];
    destinations:string[];
    runningBuses:BusTransaction[];
    constructor(private busservice:BusService,private router:Router,private bookingService:BookingService){}

    ngOnInit(){
        this.busservice.getSources().subscribe((data:string[])=>this.sources=data);
        this.busservice.getDestinations().subscribe((data:string[])=>this.destinations=data);
    }

    searchBuses(source,destination,dateOfJourney){
        this.bookingService.showRunningBuses(source,destination,dateOfJourney).subscribe((data:BusTransaction[])=>this.runningBuses=data);
    }
}