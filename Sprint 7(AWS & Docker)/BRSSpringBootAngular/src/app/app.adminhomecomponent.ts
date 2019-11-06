import {Component,OnInit} from '@angular/core';
import { UserService } from './_service/app.userservice';

@Component({
    selector: 'adminhome',
    templateUrl: './_html/app.adminhome.html'
})

export class AdminHomeComponent implements OnInit{
    constructor(private userService:UserService){}

    ngOnInit(){
        this.userService.adminHome().subscribe();
    }
}