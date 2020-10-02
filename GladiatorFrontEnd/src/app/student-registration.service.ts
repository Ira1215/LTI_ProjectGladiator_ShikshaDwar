import { Observable } from 'rxjs';
import { StudentRegistration } from './StudentRegistration';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StudentRegistrationService {

  constructor(private http:HttpClient) { }
  addUser(user:StudentRegistration):Observable<Object>{
    alert("its coming")
     return this.http.post("http://localhost:3000/registeredstudents" , user);
    }
  
    getAllUsers():Observable<StudentRegistration[]>{
    
      return this.http.get<StudentRegistration[]>("http://localhost:3000/registeredstudents");
    }
}
