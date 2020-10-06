import { Observable } from 'rxjs';
import { InstituteLogin } from './institute';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class InstituteService {

  constructor(private http:HttpClient) {}
    
     
  addInstitute(institute:InstituteLogin):Observable<any>{
    alert("You just Subscribed to InstituteLoginService");
     return this.http.post("http://localhost:9091/ShikshaDwar/users/institute",institute);
    }
  
    getAllUsers():Observable<InstituteLogin[]>{
    
      return this.http.get<InstituteLogin[]>("http://localhost:9091/ShikshaDwar/users/institute");
    }
 

   }

