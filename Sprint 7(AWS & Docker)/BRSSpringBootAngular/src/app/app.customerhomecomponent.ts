import { Component, OnInit} from '@angular/core'
import { UserService } from './_service/app.userservice'

@Component({
    selector:'customerhome',
    templateUrl: '../app/_html/app.customerhome.html'
})
export class CustomerHomeComponent implements OnInit{
    constructor(private userservice:UserService){}

    ngOnInit(){
        this.userservice.customerHome().subscribe();
    }
}