/* author Tejaswini
description : add passenger component
Created on: 19/10/2019
Last modified on: 23/10/2019
 */
import { Component,OnInit} from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Passenger } from "./_model/app.passenger";
import { Booking } from "./_model/app.booking";
import { BookingService } from "./_service/app.bookingservice";

@Component({
    selector:'addpassenger',
    templateUrl:'./_html/app.addpassenger.html'
})
export class AddPassengerComponent implements OnInit{
    passengerId:number;
    passengerName:string;
    passengerAge:number;
    passengerGender:any;
    booking:Booking={bookingId:null,bookingStatus:"",modeOfPayment:"",bus:null,user:null,passengers:null,totalCost:null,dateOfJourney:null,deleteFlag:0}
    modeOfPayment:string
    passengers:Passenger[]=[{
        passengerId:null,
        passengerName:null,
        passengerAge:0,
        passengerGender:null
    }];
    passengersCount:number=1;
    loadComponent=false;
    busTransactionId:number;
    constructor(private route:ActivatedRoute,private router:Router,private bookingService:BookingService){}
    ngOnInit(){
        this.busTransactionId=+this.route.snapshot.paramMap.get("busTransactionId");
    }

    addPassenger(){
        if(this.passengersCount<=5){
            this.passengers.push({
                    passengerId:null,
                    passengerName:null,
                    passengerAge:0,
                    passengerGender:null
            });
        this.passengersCount++;
        }
        
    }

    removePassenger(){
        this.passengers.pop();
        this.passengersCount--;
    }

    addBooking(){
        console.log("Proceed Button Clicked");
        this.booking.modeOfPayment=this.modeOfPayment;
        this.booking.passengers=this.passengers;
        this.bookingService.addBooking(this.passengers,this.busTransactionId,this.modeOfPayment).subscribe();
        this.router.navigate(['/viewbookings']);
    }


}