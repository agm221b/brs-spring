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



const brsroute: Routes=[
    {path:'addbooking:/id',component: AddBookingComponent},
    {path:'viewbookings',component: ViewBookingsComponent},
    {path:'cancelbooking/:id',component: CancelBookingComponent},
    {path:'customerhome',component: CustomerHomeComponent}

]

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,HttpClientModule,RouterModule.forRoot(brsroute)
        
    ],
    declarations: [
        AppComponent,AddBookingComponent,ViewBookingsComponent,CancelBookingComponent,
        CustomerHomeComponent
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }