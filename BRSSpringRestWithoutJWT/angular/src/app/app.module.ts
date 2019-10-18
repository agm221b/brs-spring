import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import {FormsModule} from '@angular/forms'
import { ProductComponent } from './app.productcomponent';
import {HttpClientModule} from '@angular/common/http';
import {Routes, RouterModule} from '@angular/router';
import {AboutUsComponent} from '../app/app.aboutuscomponent'
import {ShowComponent} from '../app/app.showcomponent'



const productroute: Routes=[
    {path:'',redirectTo:'aboutus',pathMatch:'full'},
    {path:'aboutus',component: AboutUsComponent},
    {path:'add',component: ProductComponent},
    {path:'show',component: ShowComponent},
]

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,HttpClientModule,RouterModule.forRoot(productroute)
        
    ],
    declarations: [
        AppComponent,ProductComponent,AboutUsComponent,ShowComponent
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }