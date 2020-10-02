import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { StudentSignup } from './StudentSignUp';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StudentsignupService {

  

  constructor(private http:HttpClient) {}
    
     
  addUser(user:StudentSignup):Observable<Object>{
   // alert("its coming");
     return this.http.post("http://localhost:3000/signedupstudents" , user);
    }
  
    getAllUsers():Observable<StudentSignup[]>{
    
      return this.http.get<StudentSignup[]>("http://localhost:3000/signedupstudents");
    }
 
}
