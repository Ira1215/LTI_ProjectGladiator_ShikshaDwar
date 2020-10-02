import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationService {

  constructor() { }

  authenticate(inputStudentEmail,inputStudentPassword)
  {
    console.log('before ' + this.isUserLoggedIn());

    if(inputStudentEmail==="Snayasishkmr@gmail.com" && inputStudentPassword==='anything')
    {
     // sessionStorage.setItem('authenticatedUser',inputStudentEmail);
    //  console.log('after '+this.isUserLoggedIn());
      return true;
    }
      return false;
  }

  isUserLoggedIn()
  {

    let user=sessionStorage.getItem('authenticatedUser')
    return !(user===null);
  }
}
