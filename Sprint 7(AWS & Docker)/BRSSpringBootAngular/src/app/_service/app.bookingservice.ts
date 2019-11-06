import { Injectable, OnInit} from '@angular/core'
import { HttpClient} from '@angular/common/http'
import { Booking } from '../_model/app.booking';
import { BusService } from './app.busservice';
import { BusTransaction } from '../_model/app.bustransaction';
import { Passenger } from '../_model/app.passenger';
import { Observable } from 'rxjs';

@Injectable({
    providedIn:'root'
})
export class BookingService{
    source:string;
    destination:string;
    dateOfJourney:any;
    runningBuses:BusTransaction[];
    constructor(private bookingHttp:HttpClient,private busService:BusService){
        
    }

    
    viewAllBookings(){
        let username=sessionStorage.getItem('username');
        return this.bookingHttp.get('http://'+ window.location.hostname+':9085/brs/viewallbookings?username='+username);
    }

    addBooking(passengers:Passenger[],busTransactionId:number,modeOfPayment:string){
        let formdata=new FormData();
        for(let i=0;i<passengers.length;i++){
            formdata.append("passengers["+i+"].passengerName",passengers[i].passengerName);
            formdata.append("passengers["+i+"].passengerAge",String(passengers[i].passengerAge));
            formdata.append("passengers["+i+"].passengerGender",passengers[i].passengerGender);

        }
        formdata.append("modeOfPayment",modeOfPayment);
        return this.bookingHttp.post("http://"+ window.location.hostname+":9085/brs/createbooking?busTransactionId="+busTransactionId,formdata);
    }

    getBookingById(bookingId:number){
        return this.bookingHttp.get('http://'+ window.location.hostname+':9085/brs/viewbooking?bookingId='+bookingId)
    }
    cancelBooking(bookingId:number){
        console.log("Cancelled...");
        return this.bookingHttp.put('http://'+ window.location.hostname+':9085/brs/cancelbooking?bookingId='+bookingId,null);
    }
    downloadTicket(bookingId:number):Observable<Blob>{
        console.log("Downloading...");
        return this.bookingHttp.get('http://'+ window.location.hostname+':9085/brs/downloadticketpdf?bookingId='+bookingId,{
            responseType:"blob"
        });
    }
    getUserDetails(username:string){
        return this.bookingHttp.get('http://'+ window.location.hostname+':9085/brs/getuser?username='+username);
    }
}