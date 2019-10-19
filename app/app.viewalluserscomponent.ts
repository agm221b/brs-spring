import { Component,OnInit } from '@angular/core'
import { User } from './_model/app.user';
import { UserService } from './_service/app.userservice';

@Component({
    selector: 'viewallusers',
    templateUrl:'../app/_html/app.viewallusers.html'
})
export class ViewAllUsersComponent implements OnInit{
    users: User[];
    constructor(private userservice:UserService){}
    ngOnInit(){
        this.userservice.viewAllUsers().subscribe((data:User[])=>this.users=data);
    }


}