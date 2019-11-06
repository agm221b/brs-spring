/* author Aditya
description : add bus component
Created on: 19/10/2019
Last modified on: 23/10/2019
 */
import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import {ShowBusesComponent} from './app.showbusescomponent';
import { BusService } from './_service/app.busservice';
import { ToastrService } from 'ngx-toastr';

@Component({
    selector: 'addbus',
    templateUrl: './_html/app.addbus.html'
})

export class AddBusComponent implements OnInit{
    ngOnInit() {
        console.log(":In oninit");
    }
        
    
    model: any = {};
    nameStatus: boolean = false;
    classStatus:boolean = false;
    typeStatus: boolean = false;
    sourceStatus: boolean = false;
    destinationStatus: boolean = false;
    seatStatus: boolean = false;
    costStatus: boolean = false;
    showBus : ShowBusesComponent;
    constructor(private service: BusService, private router: Router, private toastr: ToastrService) { }

    addBus(): any { 
        this.service.addBus(this.model)
            .subscribe((data) => console.log(data));
            //alert("Bus Added"); 
            this.toastr.success('Bus Added Successfully!', 'Congratulations!');
            this.router.navigate(['/showbuses']);
            this.showBus.ngOnInit();
    }

    validate(){
        console.log('entered in validation')
        if(this.model.busName.match("[a-zA-Z\\s]")&&this.model.busName.length>=4){
            console.log("name correctly entered")
            this.nameStatus=true;
        }
        else{
            console.log("false block busName")
            this.nameStatus=false;
            return true;
        }
        if(!(this.model.busClass==undefined)){
            console.log("class correctly entered")
            this.classStatus=true;
        }
        else{
            console.log("false block class")
            this.classStatus=false;
            return true;
        }
        if(!(this.model.busType==undefined)){
            console.log("type correctly entered")
            this.typeStatus=true;
        }
        else{
            console.log("false block type")
            this.typeStatus=false;
            return true;
        }
        if(this.model.source.match("[a-zA-Z\\s]")){
            console.log("source correctly entered")
            this.sourceStatus=true;
        }
        else{
            console.log("false block source")
            this.sourceStatus=false;
            return true;
        }
        if(this.model.destination.match("[a-zA-Z\\s]")){
            console.log("destination correctly entered")
            this.destinationStatus=true;
        }
        else{
            console.log("false block destination")
            this.destinationStatus=false;
            return true;
        }
        if(this.model.noOfSeats>0 && this.model.noOfSeats<100){
            this.seatStatus=true;
            console.log("seat entered correctly");
        }
        else{
            console.log("false block seats")
            this.seatStatus=false;
            return true;
        }
        if(this.model.costPerSeat>0 && this.model.noOfSeats<10000){
            this.costStatus=true;
            console.log("cost entered correctly");
        }
        else{
            console.log("false block cost")
            this.costStatus=false;
            return true;
        }


    }

    
}