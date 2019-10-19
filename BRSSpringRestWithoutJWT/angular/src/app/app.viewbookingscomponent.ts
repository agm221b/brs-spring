import { Component,OnInit } from '@angular/core'
import { Booking } from './_model/app.booking';
import { BookingService } from './_service/app.bookingservice';

@Component({
    selector: 'viewbookings',
    templateUrl:'app.viewbookings.html'
})
export class ViewBookingsComponent implements OnInit{
    constructor(private bookingservice:BookingService){}
    bookings: Booking[];
    ngOnInit(){
        this.bookingservice.viewAllBookings().subscribe((data:Booking[])=>this.bookings=data);
    }


}