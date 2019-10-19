import { Component,OnInit } from '@angular/core'
import { Booking } from './_model/app.booking';
import { BookingService } from './_service/app.bookingservice';

@Component({
    selector: 'viewbookings',
    templateUrl:'../app/_html/app.viewbookings.html'
})
export class ViewBookingsComponent implements OnInit{
    bookings: Booking[];
    constructor(private bookingservice:BookingService){}
    ngOnInit(){
        this.bookingservice.viewAllBookings().subscribe((data:Booking[])=>this.bookings=data);
    }


}