import { Component} from '@angular/core'
import { BookingService } from './_service/app.bookingservice';
import { BusTransaction } from './_model/app.bustransaction';


@Component({
    selector:'searchrunningbuses',
    templateUrl: './_html/app.showrunningbuses.html'
})
export class ShowRunningBusesComponent{
    runningBuses:BusTransaction[];
    constructor(private bookingService:BookingService){}
    searchRunningBuses(source,destination,dateOfJourney){
        this.bookingService.showRunningBuses(source,destination,dateOfJourney).subscribe((data:BusTransaction[])=>this.runningBuses=data);
    }
}