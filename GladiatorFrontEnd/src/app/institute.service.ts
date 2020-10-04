import { Observable } from 'rxjs';
import { InstituteLogin } from './institute';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class InstituteService {

  constructor(private http:HttpClient) {}
    
     
  addUser(user:InstituteLogin):Observable<Object>{
    alert("You just Subscribed to InstituteLoginService");
     return this.http.post("http://localhost:9091/ShikshaDwar/users/institute/login",user);
    }
  
    getAllUsers():Observable<InstituteLogin[]>{
    
      return this.http.get<InstituteLogin[]>("http://localhost:9091/ShikshaDwar/users/institute/login");
    }
 

   }

