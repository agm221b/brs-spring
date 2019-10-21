import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { FormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';


import {RouterModule, Routes} from '@angular/router';

import { AddBusComponent } from './app.addbuscomponent';
import { ShowBusesComponent } from './app.showbusescomponent';
import { AdminHomeComponent } from './app.adminhomecomponent';

//{path: 'show/:text', component: ShowComponent},
const myroutes:Routes= [
    {path: '', redirectTo:'adminhome', pathMatch: 'full'},
    {path: 'adminhome', component: AdminHomeComponent},
    {path: 'addbus', component: AddBusComponent},
    {path: 'showbuses', component: ShowBusesComponent},
    
];

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        RouterModule.forRoot(myroutes)
    ],
    declarations: [
        AppComponent,
        AddBusComponent,
        ShowBusesComponent,
        AdminHomeComponent
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }