import { StudentApplication } from './studentapplication';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentapplicationService {

  constructor(private http:HttpClient) {}
   
  addUser(user:StudentApplication , email):Observable<any>{
   alert("You just Subscribed to studentApplicationService");

    return this.http.post("http://localhost:9091/ShikshaDwar/users/student/ApplyScholarship/"+email ,user);
   }
 
  //  getAllUsers():Observable<StudentApplication[]>{
   
  //    return this.http.get<StudentApplication[]>("http://localhost:9091/ShikshaDwar/users/student/application");
  //  }

   
}
