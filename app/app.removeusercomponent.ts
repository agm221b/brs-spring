import { Component } from '@angular/core'
import { User } from './_model/app.user';
import {UserService} from './_service/app.userservice';

@Component({
    selector: 'removeuser',
    templateUrl:'../app/_html/app.removeuser.html'
})
export class RemoveUserComponent{
    users:User[];

    constructor(private userService: UserService) { }

/* 
    remove(user: User): void {
        this.users = this.users.filter(h => h !== user);
        this.userService.removeUser(userId).subscribe();
      }
 */

}