import { Observable } from 'rxjs';
import { StudentRegistration } from './StudentRegistration';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StudentRegistrationService {

  constructor(private http:HttpClient) { }



  addUser(user:StudentRegistration ,email:string,instituteCode:string):Observable<any>{
    alert("We are in the student Registration Service");
     return this.http.post("http://localhost:9091/ShikshaDwar/users/student/registration/"+email+'/'+instituteCode, user);
    }

   

    getAll():Observable<StudentRegistration[]>{
      alert("coming")
      return this.http.get<StudentRegistration[]>("http://localhost:9091/ShikshaDwar/users/allStudentRegistration")
    }
  
    // getAllUsers():Observable<StudentRegistration[]>{
    
    //   return this.http.get<StudentRegistration[]>("http://localhost:9091/ShikshaDwar/users/student/registration");
    // }


}
