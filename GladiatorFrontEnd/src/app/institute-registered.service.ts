import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { InstitutesRegistered } from './instituteRegister';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class InstituteRegisteredService {

  
  constructor(private http:HttpClient) {}
   
  addUser(user:InstitutesRegistered):Observable<Object>{
   alert("its coming")
    return this.http.post("http://localhost:3000/registeredinstitutes" , user);
   }
 
   getAllUsers():Observable<InstitutesRegistered[]>{
   
     return this.http.get<InstitutesRegistered[]>("http://localhost:3000/registeredinstitutes");
   }
}
