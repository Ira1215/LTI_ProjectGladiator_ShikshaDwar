import { StudentApplication } from './studentapplication';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentapplicationService {

  constructor(private http:HttpClient) {}
   
  addUser(user:StudentApplication):Observable<Object>{
   alert("its coming")
    return this.http.post("http://localhost:3000/students" , user);
   }
 
   getAllUsers():Observable<StudentApplication[]>{
   
     return this.http.get<StudentApplication[]>("http://localhost:3000/students");
   }

   
}
