import { Router } from '@angular/router';
import { StudentSignup } from './../StudentSignUp';
import { StudentRegistration } from './../StudentRegistration';
import { StudentsignupService } from './../StudentSignup.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HardcodedAuthenticationService } from './../service/hardcoded-authentication.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student-login',
  templateUrl: './student-login.component.html',
  styleUrls: ['./student-login.component.css']
})
export class StudentLoginComponent implements OnInit  {
  
  form:FormGroup;
  isThereOrNot=false;
  error:boolean=false;
  constructor(private service:StudentsignupService,private router:Router)
  {

  }
  registeredStudents:StudentSignup[];
  ngOnInit(): void {

    this.form= new FormGroup({
      studentEmailId: new FormControl('',Validators.required),
      studentPassword: new FormControl('',Validators.required)
  });
  
  }
  invalid = false;
  
  onClick()
  {
    alert("You just clicked the Login button");

    let s:StudentSignup = new StudentSignup(this.form.controls.studentEmailId.value, this.form.controls.studentPassword.value)
  
    this.service.loginUser(s).subscribe(res => {
      if (res.status == 200) {
     alert("ok");
        console.log("SUCCESS", res.status)
        localStorage.setItem('loginEmail', this.form.controls.studentEmailId.value);
        this.router.navigate(['/studentDashboard']);
      
      }
    },
      err => {
        if (err.status == 200) {
          alert("ok2");
          console.log("error false", err.status)
          localStorage.setItem('loginEmail', this.form.controls.studentEmailId.value);
          this.router.navigate(['/studentDashboard']);

        }
        else {
          this.invalid = true;
          alert("You have Provided Invalid Credentails");
          setTimeout(function () {
            window.location.href = '';
          }, 400);
        }


      })

   
  

}
}








 /*  for(let rs of this.registeredStudents)
    {
      
      if(rs.studentEmailId==this.form.controls.studentEmailId.value)
      {
        alert("in between ifs");
        this.isThereOrNot=true;
        if(rs.studentPassword==this.form.controls.studentPassword.value)
        {
          
          this.isThereOrNot=true
          sessionStorage.setItem("signedUpUser",this.form.controls.studentEmailId.value);
          alert(sessionStorage.getItem("signedUpUser"));
          this.router.navigate(['/studentDashboard']);
        }
        else{
          alert("Invalid Credentials");
        }
      }
    }
  
    if(!this.isThereOrNot)
    {
      this.error=true;
    }
  }
 
   get StudentEmail()
  {
    return this.form.get('inputStudentEmail');
  }
 */