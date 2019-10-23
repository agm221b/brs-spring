import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {UserService} from './_service/app.userservice';
import {ViewAllUsersComponent} from './app.viewalluserscomponent';

@Component({
    selector: 'adduser',
    templateUrl:'../app/_html/app.adduser.html'
})

export class AddUserComponent implements OnInit{
    ngOnInit() {
        console.log(":In oninit");
    }
    
    model:any={};
    usernameStatus: boolean=false;
    passStatus: boolean=false;
    emailStatus: boolean=false;
    phoneNumberStatus: boolean=false;
    showUser : ViewAllUsersComponent;
    constructor(private service: UserService, private router : Router){}

    addUser():any{
        this.service.addUser(this.model).subscribe((data)=>console.log(data));

        alert("User added");
        this.router.navigate(['/showusers']);
    }

    validate() {
        console.log('entered in validation')
        if(this.model.username.match("[a-zA-Z\\s]")&&this.model.username.length>=4) {
            console.log("name correctly entered")
            this.usernameStatus=true;
        }
        else{
            console.log("false block username")
            this.usernameStatus=false;
            return true;
        }
        if(!(this.model.pass==undefined)){
            console.log("password correctly entered")
            this.passStatus=true;
        }
        else{
            console.log("false block pass")
            this.passStatus=false;
            return true;
        }
        
        if(this.model.email.match("[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$")){
            console.log("email correctly entered")
            this.emailStatus=true;
        }
        else{
            console.log("false block email")
            this.emailStatus=false;
            return true;
        }
        if(this.model.phoneNumber.match("[6-9]\\d{9}")&&this.model.phoneNumber.length==10){
            console.log("phone number correctly entered")
            this.phoneNumberStatus=true;
        }
        else{
            console.log("false block phone number")
            this.phoneNumberStatus=false;
            return true;
        }
    }
       

  
    
}