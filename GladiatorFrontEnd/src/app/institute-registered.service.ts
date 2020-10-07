import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { InstitutesRegistered } from './instituteRegister';
import { Injectable } from '@angular/core';
import { InstituteLogin } from './institute';

@Injectable({
  providedIn: 'root'
})
export class InstituteRegisteredService {

  
  constructor(private http:HttpClient) {}
   
  addUser(user:InstitutesRegistered , dise):Observable<any>{

    return this.http.post("http://localhost:9091/ShikshaDwar/users/institute/registration/" + dise,user);
   }
 

   getAllinstitutes():Observable<InstituteLogin[]>{
     return this.http.get<InstituteLogin[]>("http://localhost:9091/ShikshaDwar/users/allInsituteLogin")
   }


   getInstitutesByCode(code):Observable<InstitutesRegistered>{
     return this.http.get<InstitutesRegistered>("http://localhost:9091/ShikshaDwar/users/institute/getByCode/"+code)
   }


   getApproved(code, inst1:InstitutesRegistered){
     return this.http.put("http://localhost:9091/ShikshaDwar/users/nodal/approveInstitute/"+ code , inst1)
   }
  //  getAllUsers():Observable<InstitutesRegistered[]>{
   
  //    return this.http.get<InstitutesRegistered[]>("http://localhost:9091/ShikshaDwar/users/institute/");
  //  }
}
