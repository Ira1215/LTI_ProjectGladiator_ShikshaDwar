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
  this.service.getAllUsers().subscribe(data =>{this.registeredStudents=data});
  }
  
  onClick()
  {
    for(let rs of this.registeredStudents)
    {
      if(rs.studentEmailId==this.form.controls.studentEmailId.value)
      {
        this.isThereOrNot=true;
        if(rs.studentPassword==this.form.controls.studentPassword.value)
        {
          this.isThereOrNot=true
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

}

  








