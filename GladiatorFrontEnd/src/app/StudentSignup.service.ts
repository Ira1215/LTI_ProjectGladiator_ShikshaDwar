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
    console.log(user);
      //alert("we are in service class");
     return this.http.post("http://localhost:9091/ShikshaDwar/users/student/login",user);
    }
  
    getAllUsers():Observable<StudentSignup[]>{
    
      return this.http.get<StudentSignup[]>("http://localhost:9091/ShikshaDwar/users/student/login");
    }
 
}
