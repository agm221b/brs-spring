import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import {FormsModule} from '@angular/forms'


import {HttpClientModule} from '@angular/common/http';
import {Routes, RouterModule} from '@angular/router';
import { AddBookingComponent } from './app.addbookingcomponent';
import { ViewBookingsComponent } from './app.viewbookingscomponent';
import { CancelBookingComponent } from './app.cancelbookingcomponent';



const brsroute: Routes=[
    {path:'',redirectTo:'aboutus',pathMatch:'full'},
    {path:'addbooking',component: AddBookingComponent},
    {path:'viewbookings',component: ViewBookingsComponent},
    {path:'cancelbooking',component: CancelBookingComponent},

]

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,HttpClientModule,RouterModule.forRoot(brsroute)
        
    ],
    declarations: [
        AppComponent,AddBookingComponent,ViewBookingsComponent,CancelBookingComponent
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }