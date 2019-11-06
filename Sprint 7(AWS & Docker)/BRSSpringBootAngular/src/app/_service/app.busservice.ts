/* author Aditya
description contains the service methods of bus
Created on: 19/10/2019
Last modified on: 23/10/2019
 */
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
        return this.myhttp.get('http://'+ window.location.hostname+':9085/brs/showbuses');
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
        console.log(form);
        return this.myhttp.post('http://'+ window.location.hostname+':9085/brs/addbusdetails', form);

    }

    getSources(){
        return this.myhttp.get('http://'+ window.location.hostname+':9085/brs/getsources');
    }
    getDestinations(){
        return this.myhttp.get('http://'+ window.location.hostname+':9085/brs/getdestinations');
    }

    deleteBus(id:number){ 
        return this.myhttp.put("http://"+ window.location.hostname+":9085/brs/deletebus?busId="+id,null);
    }

    showRunningBuses(src:string,dest:string,journeydate:any){
        console.log(dest)
        console.log("http://"+ window.location.hostname+":9085/brs/showrunningbuses?source="+src+"&destination="+dest+"&journeydate="+journeydate);
        return this.myhttp.get("http://"+ window.location.hostname+":9085/brs/showrunningbuses?source="+src+"&destination="+dest+"&journeydate="+journeydate);
    }

}