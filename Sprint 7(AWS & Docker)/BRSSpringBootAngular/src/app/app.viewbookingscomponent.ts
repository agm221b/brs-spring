/* author Tejaswini
description : view booking component
Created on: 19/10/2019
Last modified on: 23/10/2019
 */
import { Component, OnInit } from '@angular/core'
import { Booking } from './_model/app.booking';

import { BookingService } from './_service/app.bookingservice';
import { ToastrService } from 'ngx-toastr';



@Component({
    selector: 'viewbookings',
    templateUrl: '../app/_html/app.viewbookings.html'
})
export class ViewBookingsComponent implements OnInit {
    confirmResult = null;
    bookings: Booking[]=[];

    public popoverTitle: string = 'Cancel Ticket';
    public popoverMessage: string = 'Do you want to cancel your ticket?';
    public confirmClicked: boolean=false;
    public cancelClicked: boolean = false;

    constructor(private bookingservice: BookingService, private toastr:ToastrService) { }
    ngOnInit() {
        this.bookingservice.viewAllBookings().subscribe((data: Booking[]) => this.bookings = data);
        this.bookings.sort((a,b)=>b.bookingId-a.bookingId);
    }

    cancelBooking(bookingId) {
        this.bookingservice.cancelBooking(bookingId).subscribe();
        location.reload();
        alert("Booking Cancelled Successfully")
    }

    downloadTicketPdf(bookingId:number){
        this.bookingservice.downloadTicket(bookingId).subscribe(
            response => {
                var blobObj=new Blob([response],{type:'application/pdf'});    
            },
            error => {
                console.error(`Error: ${error.error}`)
                //console.error(`Error: ${error.message}`);
            });
            console.log("Downloaded");
    }




}