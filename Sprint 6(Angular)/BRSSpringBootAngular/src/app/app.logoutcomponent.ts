import { Component, OnInit } from "@angular/core";
import { TokenStorageService } from "./_service/app.tokenstorageservice";

@Component({
    selector:'logout',
    templateUrl:'./_html/app.logout.html'
})
export class LogoutComponent implements OnInit{
    constructor(private service:TokenStorageService){}

    ngOnInit(){
        this.service.signOut();
    }

}