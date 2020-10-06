import { Observable } from 'rxjs';
import { InstituteLogin } from './institute';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

import {Config} from  'protractor';

@Injectable({
  providedIn: 'root'
})
export class InstituteService {

  constructor(private http:HttpClient) {}
    
     
  addInstitute(institute:InstituteLogin):Observable<any>{
 
     return this.http.post("http://localhost:9091/ShikshaDwar/users/institute/AddLogin",institute);
    }



    loginUser(login): Observable<HttpResponse<Config>> {
      return this.http.post<Config>("http://localhost:9091/ShikshaDwar/users/institute/login", login, { observe: 'response' });
    }
  
    // getAllUsers():Observable<InstituteLogin[]>{
    
    //   return this.http.get<InstituteLogin[]>("http://localhost:9091/ShikshaDwar/users/institute");
    // }
 

   }

