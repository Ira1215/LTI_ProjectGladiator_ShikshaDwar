import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { InstitutesRegistered } from './instituteRegister';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class InstituteRegisteredService {

  
  constructor(private http:HttpClient) {}
   
  addUser(user:InstitutesRegistered , dise):Observable<any>{

    return this.http.post("http://localhost:9091/ShikshaDwar/users/institute/registration/" + dise,user);
   }
 
  //  getAllUsers():Observable<InstitutesRegistered[]>{
   
  //    return this.http.get<InstitutesRegistered[]>("http://localhost:9091/ShikshaDwar/users/institute/");
  //  }
}
