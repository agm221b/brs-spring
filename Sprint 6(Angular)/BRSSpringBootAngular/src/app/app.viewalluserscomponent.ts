import { Component,OnInit } from '@angular/core'
import { User } from './_model/app.user';
import { UserService } from './_service/app.userservice';
import { ToastrService } from 'ngx-toastr';

@Component({
    selector: 'viewallusers',
    templateUrl:'../app/_html/app.viewallusers.html'
})
export class ViewAllUsersComponent implements OnInit{
    user: User;
    id;
    users: User[]=[];
    constructor(private userservice:UserService, private toastr: ToastrService){
        console.log("In constructor");
    }
    sub;
    ngOnInit(): void {
        console.log("NG On Init");
        this.userservice.viewAllUsers().subscribe((data:User[])=>this.users=data);
    }

    removeUser(id: any): any {
        console.log(id);
        this.userservice.removeUser(id).subscribe();
        this.toastr.success('User Deleted Successfully!', 'Congratulations!');
        location.reload();
        
        
    }

    sortById(){
        this.users.sort(
            (val1, val2)=>
            val2.userId-val1.userId
        );
    }

}

