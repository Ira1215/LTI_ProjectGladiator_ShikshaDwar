import { Observable } from 'rxjs';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { StudentSignup } from './StudentSignUp';
import { Injectable } from '@angular/core';
import {Config} from  'protractor';

@Injectable({
  providedIn: 'root'
})
export class StudentsignupService {

  

  constructor(private http:HttpClient) {}
 
  
  addUser(user:StudentSignup):Observable<any>{
  
      alert("StudentSignUp Service Called");
     return this.http.post("http://localhost:9091/ShikshaDwar/users/student/AddLogin",user);
    }

    loginUser(login: StudentSignup): Observable<HttpResponse<Config>> {
      return this.http.post<Config>(" http://localhost:9091/ShikshaDwar/users/student/login", login, { observe: 'response' });
    }
  

 
}
