import { Injectable} from '@angular/core'
import { HttpClient} from '@angular/common/http'
import { Booking } from '../_model/app.booking';

@Injectable({
    providedIn:'root'
})
export class BookingService{
    constructor(private bookingHttp:HttpClient){}

    viewAllBookings(){
        return this.bookingHttp.get("http://localhost:9085/brs/viewallbookings");
    }

    addBooking(booking:any,busTransactionId:number){
        return this.bookingHttp.post("http://localhost:9085/brs/createbooking?busTransactionId="+busTransactionId,booking);
    }

    getBookingById(bookingId:number){
        return this.bookingHttp.get("http://localhost:9085/brs/viewbooking?bookingId="+bookingId)
    }
    cancelBooking(bookingId:number){
        let booking=this.bookingHttp.get("http://localhost:9085/brs/viewbooking?bookingId="+bookingId);
        return this.bookingHttp.put("http://localhost:9085/brs/cancelbooking?bookingId="+bookingId,booking);
    }
}