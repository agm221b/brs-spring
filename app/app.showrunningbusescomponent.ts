import { Component,OnInit} from '@angular/core'
import { BookingService } from './_service/app.bookingservice';
import { BusTransaction } from './_model/app.bustransaction';
import { BusService } from './_service/app.busservice';
import { ActivatedRoute, Router } from '@angular/router';
import { DatePipe } from '@angular/common';


@Component({
    selector:'searchrunningbuses',
    templateUrl: './_html/app.showrunningbuses.html'
})
export class ShowRunningBusesComponent implements OnInit{
    loadComponent=true;
    src:string;
    dest:string;
    journeydate:any;
    runningBuses:BusTransaction[]=[];
    dateFormat='dd-MM-yyyy';
    constructor(private busService:BusService,private router:Router,private route:ActivatedRoute,private datepipe:DatePipe){}
    ngOnInit(){
        this.src=this.route.snapshot.paramMap.get("src");
        this.dest=this.route.snapshot.paramMap.get("dest");
        this.journeydate=this.route.snapshot.paramMap.get("journeydate");
        this.searchRunningBuses();
    }
    searchRunningBuses(){
        console.log("Hello");
        this.busService.showRunningBuses(this.src,this.dest,this.journeydate).subscribe((data:BusTransaction[])=>this.runningBuses=data);
        console.log(this.runningBuses);
    }
    addPassengerDetails(busTransactionId:number){
        this.router.navigate(['/addpassenger',busTransactionId]);
    }
    
}