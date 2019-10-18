import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import {FormsModule} from '@angular/forms'
import { ShowCarByImage } from './app.showcars';

@NgModule({
    imports: [
        BrowserModule,
        FormsModule
        
    ],
    declarations: [
        AppComponent,
        ShowCarByImage
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }