import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ForgotUpdatePasswordService {

  constructor(private http:HttpClient) { }

  updatePassword(username:string,adminLogin)
  {
    alert("UpdatePassword Service Called");
   return this.http.put("http://localhost:9091/ShikshaDwar/users/admin/forgotPassword/"+username,adminLogin);
  }
}
