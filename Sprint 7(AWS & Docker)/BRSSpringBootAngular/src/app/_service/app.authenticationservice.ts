import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthLoginInfo} from '../_model/app.authlogininfo';
import { JwtResponse} from '../_model/app.jwtresponse';
import { SignUpInfo} from '../_model/app.signupinfo';
import { Injectable } from '@angular/core';
 
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn:'root'
})
export class AuthenticationService {
 
  private loginUrl = 'http://'+ window.location.hostname+':9085/auth/login';
  private signupUrl = 'http://'+ window.location.hostname+':9085/auth/register';
 
  constructor(private http: HttpClient) {
  }
 
  // JwtResponse(accessToken,type,username,authorities)
  attemptAuth(credentials: AuthLoginInfo): Observable<JwtResponse> {
    return this.http.post<JwtResponse>(this.loginUrl, credentials, httpOptions);
  }
 
  // SignUpInfo(name,username,email,role,password)
  signUp(info: SignUpInfo): Observable<string> {
    return this.http.post<string>(this.signupUrl, info, httpOptions);
  }
}