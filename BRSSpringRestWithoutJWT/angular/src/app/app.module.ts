import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import {FormsModule} from '@angular/forms'
import {HttpClientModule} from '@angular/common/http';
import {Routes, RouterModule} from '@angular/router';




const productroute: Routes=[
 
]

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,HttpClientModule,RouterModule.forRoot(productroute)
        
    ],
    declarations: [
        AppComponent
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }