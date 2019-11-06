/* author Tejaswini, Aditya, Mayank
description : main app module
Created on: 19/10/2019
Last modified on: 23/10/2019
 */
import { NgModule, Component } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { HttpClientModule } from '@angular/common/http';


import { RouterModule, Routes } from '@angular/router';
import { ErrorComponent } from './app.errorcomponent';
import { AddBusComponent } from './app.addbuscomponent';
import { ShowBusesComponent } from './app.showbusescomponent';
import { AdminHomeComponent } from './app.adminhomecomponent';
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpErrorInterceptor } from './app.httperrorinterceptor';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { ToastrModule } from 'ngx-toastr';
import {LoginComponent} from './app.logincomponent'
import { AddBookingComponent } from './app.addbookingcomponent';
import { ViewBookingsComponent } from './app.viewbookingscomponent';
import { CancelBookingComponent } from './app.cancelbookingcomponent';
import { CustomerHomeComponent } from './app.customerhomecomponent';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { ShowRunningBusesComponent } from './app.showrunningbusescomponent';
import { DatePipe } from '@angular/common'
import { AddPassengerComponent } from './app.addpassengercomponent';


import { AddUserComponent } from './app.addusercomponent';
import { ViewAllUsersComponent } from './app.viewalluserscomponent';
import { HomeComponent } from './app.homecomponent';
import { httpInterceptorProviders } from './app.authinterceptor';
import { RegisterComponent } from './app.registercomponent';
import { HelpComponent} from './app.helpcomponent';
import { ContactUsComponent} from './app.contactuscomponent';
import { LogoutComponent } from './app.logoutcomponent';
import { AboutUsComponent } from './app.aboutuscomponent';


//{path: 'show/:text', component: ShowComponent},
const myroutes: Routes = [
    
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'adminhome', component: AdminHomeComponent},
    { path: 'addbus', component: AddBusComponent},
    { path: 'showbuses', component: ShowBusesComponent},
    {path:'login',component:LoginComponent},
    {path:'logout',component:LogoutComponent},
    { path: 'register', component: RegisterComponent },
    {path:'addbooking',component: AddBookingComponent},
    {path:'viewbookings',component: ViewBookingsComponent},
    {path:'cancelbooking/:bookingId',component: CancelBookingComponent},
    {path:'customerhome',component: CustomerHomeComponent},
    {path:'searchrunningbuses/:src/:dest/:journeydate',component: ShowRunningBusesComponent},
    {path:'addpassenger/:busTransactionId',component:AddPassengerComponent},
    { path: 'adduser', component: RegisterComponent },
    { path: 'showusers', component: ViewAllUsersComponent },
    { path: 'help', component: HelpComponent },
    { path: 'contactus', component: ContactUsComponent },
    { path: '**', component: ErrorComponent }
];

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        RouterModule.forRoot(myroutes),
        BrowserAnimationsModule, // required animations module
        ToastrModule.forRoot(), // ToastrModule added
        NgxPaginationModule,
        NgbModule.forRoot(),
        ConfirmationPopoverModule.forRoot({ confirmButtonType: 'danger' })

    ],
    declarations: [
        AppComponent,
        HomeComponent,
        AddBusComponent,
        ShowBusesComponent,
        AdminHomeComponent,
        LoginComponent,
        ErrorComponent,
        HelpComponent,
        ContactUsComponent,
        AddBookingComponent, ViewBookingsComponent, CancelBookingComponent,
        CustomerHomeComponent, ShowRunningBusesComponent, AddPassengerComponent
        , RegisterComponent, ViewAllUsersComponent,LogoutComponent
    ],
    providers: [httpInterceptorProviders,DatePipe],
    entryComponents: [],
    bootstrap: [AppComponent]
})

export class AppModule { }