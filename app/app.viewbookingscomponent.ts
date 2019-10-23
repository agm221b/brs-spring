import { Component, OnInit } from '@angular/core'
import { Booking } from './_model/app.booking';
import { BookingService } from './_service/app.bookingservice';
import { SimpleModalService } from 'ngx-simple-modal';
import { ConfirmComponent } from './confirmdialog/app.confirmcomponent';
import {saveAs} from 'file-saver'

@Component({
    selector: 'viewbookings',
    templateUrl: '../app/_html/app.viewbookings.html'
})
export class ViewBookingsComponent implements OnInit {
    confirmResult = null;
    bookings: Booking[];

    public popoverTitle: string = 'Cancel Ticket';
    public popoverMessage: string = 'Do you want to cancel your ticket?';
    public confirmClicked: boolean=false;
    public cancelClicked: boolean = false;

    constructor(private bookingservice: BookingService, private simpleModalService: SimpleModalService) { }
    ngOnInit() {
        this.bookingservice.viewAllBookings().subscribe((data: Booking[]) => this.bookings = data);
    }

    cancelBooking(bookingId) {
        this.bookingservice.cancelBooking(bookingId).subscribe();
        location.reload();
    }

    downloadTicket(bookingId:number){
        this.bookingservice.downloadTicket(bookingId).subscribe(
            response => {
                var blobObj=new Blob([response],{type:'application/pdf'});
                var ticket='ticket.pdf';
                saveAs(blobObj,ticket);       
            },
            error => {
                console.error(`Error: ${error.error}`)
                //console.error(`Error: ${error.message}`);
            });
            console.log("Downloaded");
    }




}