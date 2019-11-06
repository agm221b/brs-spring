import { Component,OnInit } from '@angular/core'
import { Booking } from './_model/app.booking';
import { BookingService } from './_service/app.bookingservice';
import { SimpleModalService } from 'ngx-simple-modal';
import { ConfirmComponent } from './confirmdialog/app.confirmcomponent';

@Component({
    selector: 'viewbookings',
    templateUrl:'../app/_html/app.viewbookings.html'
})
export class ViewBookingsComponent implements OnInit{
    confirmResult = null;
    bookings: Booking[];
    constructor(private bookingservice:BookingService,private simpleModalService: SimpleModalService){}
    ngOnInit(){
        this.bookingservice.viewAllBookings().subscribe((data:Booking[])=>this.bookings=data);
    }

    showConfirm(bookingId) {
        this.simpleModalService.addModal(ConfirmComponent, {
          title: 'Confirmation',
          message: 'Bla bla confirm some action?'})
          .subscribe((isConfirmed) => {
            // Get modal result
            this.confirmResult = isConfirmed;
            this.bookingservice.cancelBooking(bookingId).subscribe(()=>console.log("Booking cancelled"));
        });
      }

      


}