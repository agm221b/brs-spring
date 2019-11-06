/* author Mayank
description contains the service methods of user
Created on: 19/10/2019
Last modified on: 23/10/2019
 */
import { Injectable} from '@angular/core'
import { HttpClient} from '@angular/common/http'

@Injectable({
    providedIn:'root'
})
export class UserService{

    temp:any;
    //Dependency Injection
    constructor(private userHttp:HttpClient){}
    customerHome(){
        return this.userHttp.get("http://"+ window.location.hostname+":9085/brs/customerhome");
    }

    adminHome(){
        return this.userHttp.get("http://"+ window.location.hostname+":9085/brs/adminhome");
    }
     viewAllUsers(){
        return this.userHttp.get("http://"+ window.location.hostname+":9085/brs/showusers");
    }

    addUser(data:any) {
        
        //For RequestBody
        //return this.myhttp.post('http://localhost:9088/product/add',data);
        
        //For Model Attribute
        let form=new FormData();
        form.append("username", data.username);
        form.append("pass", data.pass);
        form.append("userType", data.userType);
        form.append("email", data.email);
        form.append("phoneNumber", data.phoneNumber);
        
        return this.userHttp.post("http://"+ window.location.hostname+"9085/brs/adduser", form);
    } 

   
     removeUser(id:number){
        return this.userHttp.delete("http://"+ window.location.hostname+"9085/brs/removeuser?userId="+ id);
    } 

    

  

  

   

}