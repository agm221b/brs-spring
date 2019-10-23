import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import {FormsModule} from '@angular/forms'
import {HttpClientModule} from '@angular/common/http';
import {Routes, RouterModule} from '@angular/router';
import { AddBookingComponent } from './app.addbookingcomponent';
import { ViewBookingsComponent } from './app.viewbookingscomponent';
import { CancelBookingComponent } from './app.cancelbookingcomponent';
import { CustomerHomeComponent } from './app.customerhomecomponent';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SimpleModalModule } from 'ngx-simple-modal';
import { ConfirmComponent } from './confirmdialog/app.confirmcomponent';
import { ShowRunningBusesComponent } from './app.showrunningbusescomponent';
import { DatePipe } from '@angular/common'
import { AddPassengerComponent } from './app.addpassengercomponent';
import {NgxPaginationModule} from 'ngx-pagination';
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import{ AddUserComponent} from './app.addusercomponent';
import{ViewAllUsersComponent} from './app.viewalluserscomponent';

const brsroute: Routes=[
    {path:'addbooking',component: AddBookingComponent},
    {path:'viewbookings',component: ViewBookingsComponent},
    {path:'cancelbooking/:bookingId',component: CancelBookingComponent},
    {path:'customerhome',component: CustomerHomeComponent},
    {path:'searchrunningbuses/:src/:dest/:journeydate',component: ShowRunningBusesComponent},
    {path:'addpassenger/:busTransactionId',component:AddPassengerComponent},
    {path: 'adduser', component: AddUserComponent},
    {path:'showusers', component:ViewAllUsersComponent}
]

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,HttpClientModule,RouterModule.forRoot(brsroute),NgbModule.forRoot(),
        SimpleModalModule.forRoot({container: "modal-container"}),NgxPaginationModule,
        ConfirmationPopoverModule.forRoot({
            confirmButtonType:'danger'
        })
    ],
    declarations: [
        AppComponent,AddBookingComponent,ViewBookingsComponent,CancelBookingComponent,
        CustomerHomeComponent,ConfirmComponent,ShowRunningBusesComponent,AddPassengerComponent
        , AddUserComponent, ViewAllUsersComponent
		],
    providers: [ DatePipe],
    bootstrap: [AppComponent]
})

export class AppModule { }