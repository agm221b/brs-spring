export class SignUpInfo {
    name: string;
    username: string;
    email: string;
    roles: string;
    password: string;
    deleteFlag:number;
    phoneNumber:string;
    userType:string;
    active:boolean;

    constructor(name: string, username: string, email: string, password: string,phoneNumber:string,userType:string) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType=userType;
        if(this.userType==='C'){
            this.roles='ROLE_CUSTOMER';
        }else{
            this.roles='ROLE_ADMIN';
        }
        this.deleteFlag=0;
        this.phoneNumber=phoneNumber;
        this.active=true;
    }
}
