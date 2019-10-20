import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})

export class BusService{

    temp:any;

    //Dependency Injection
    constructor(private myhttp:HttpClient){}

    getAllBuses(){
        return this.myhttp.get('http://localhost:9081/brs/showbuses');
    }
    
    addBus(data:any){
        //For RequestBody
        //return this.myhttp.post('http://localhost:9088/product/add',data);
        
        //For Model Attribute
        let form=new FormData();
        form.append("busName", data.busName);
        form.append("busType", data.busType);
        form.append("busClass", data.busClass);
        form.append("source", data.source);
        form.append("destination", data.destination);
        form.append("startTime", data.startTime);
        form.append("endTime", data.endTime);
        form.append("costPerSeat", data.costPerSeat);
        form.append("noOfSeats", data.noOfSeats);
        return this.myhttp.post('http://localhost:9081/brs/addbusdetails', form);

    }

    deleteBus(id:number){ 
        return this.myhttp.delete("http://localhost:9081/brs/deletebus?busId="+id);
    }

}