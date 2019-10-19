import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import {FormsModule} from '@angular/forms'
<<<<<<< HEAD
import { ProductComponent } from './app.productcomponent';
import {HttpClientModule} from '@angular/common/http';
import {Routes, RouterModule} from '@angular/router';
import {AboutUsComponent} from '../app/app.aboutuscomponent'
import {ShowComponent} from '../app/app.showcomponent'
=======
import {HttpClientModule} from '@angular/common/http';
import {Routes, RouterModule} from '@angular/router';

>>>>>>> ad7bafc963af85c480d693143d7d93949d20a436



const productroute: Routes=[
<<<<<<< HEAD
    {path:'',redirectTo:'aboutus',pathMatch:'full'},
    {path:'aboutus',component: AboutUsComponent},
    {path:'add',component: ProductComponent},
    {path:'show',component: ShowComponent},
=======
 
>>>>>>> ad7bafc963af85c480d693143d7d93949d20a436
]

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,HttpClientModule,RouterModule.forRoot(productroute)
        
    ],
    declarations: [
<<<<<<< HEAD
        AppComponent,ProductComponent,AboutUsComponent,ShowComponent
=======
        AppComponent
>>>>>>> ad7bafc963af85c480d693143d7d93949d20a436
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }