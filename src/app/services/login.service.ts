import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url="https://localhost:4200"
  constructor(private http:HttpClient) { }


// calling hte server to generate token 


generateToken(credentials : any){
  //token generated
  return this.http.post(`${this.url}/token`, credentials)

}

  //for user login
  loginUser(token)
  {
    localStorage.setItem("token", token)
    return true;
  }
  //to check if the user is logged in
  isLoggedIn()
  {

  let token=localStorage.getItem("token");
  if(token==undefined || token==''|| token==null)
  {
    return false;
  }
  else{
    return true;  }

  }
// to logout the user
  logout(){
    localStorage.removeItem('token removed') ;
  return true; }

  getToken(){
    return localStorage.getItem("token");
  }

  
}
