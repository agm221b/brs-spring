import { Injectable} from '@angular/core'
import { HttpClient} from '@angular/common/http'
import { User } from '../_model/app.user';

@Injectable({
    providedIn:'root'
})
export class UserService{
    constructor(private userHttp:HttpClient){}

     viewAllUsers(){
        return this.userHttp.get("http://localhost:9085/brs/showusers");
    }

   /*  addUser(user:any){
        return this.userHttp.post("http://localhost:9085/brs/adduser");
    } */

   
   /*  removeUser(bookingId:number){
        let booking=this.bookingHttp.get("http://localhost:9085/brs/viewbooking?bookingId="+bookingId);
        return this.bookingHttp.put("http://localhost:9085/brs/cancelbooking?bookingId="+bookingId,booking);
    }  */
}