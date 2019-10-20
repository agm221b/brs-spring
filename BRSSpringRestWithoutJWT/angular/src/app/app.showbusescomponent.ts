import {Component, OnInit} from '@angular/core';
import {BusService} from './_service/app.busservice';
import {Bus} from './_model/app.bus';
import {Router} from '@angular/router';
import { routerNgProbeToken } from '@angular/router/src/router_module';

@Component({
    selector: 'showbuses',
    templateUrl: './_html/app.showbuses.html'
})

export class ShowBusesComponent implements OnInit{
    flag: boolean =true;

    busList: Bus[]=[];

    constructor(private service: BusService, private router: Router){

    }
    
    ngOnInit(){
        this.service.getAllBuses().subscribe((data : Bus[])=> this.busList= data);
    }

    deleteBus(id: any):any{
        this.service.deleteBus(id).subscribe();
        location.reload();
    }
}