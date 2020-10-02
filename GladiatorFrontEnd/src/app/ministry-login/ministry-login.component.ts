import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-ministry-login',
  templateUrl: './ministry-login.component.html',
  styleUrls: ['./ministry-login.component.css']
})
export class MinistryLoginComponent implements OnInit {
  ministryLoginForm: FormGroup;
  submitted = false;
  user:string="ministry";
  pass:string="ministry";
  

  constructor(private formBuilder:FormBuilder,private router:Router) { }

  ngOnInit(): void {
    this.ministryLoginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required] 
    })
  }

  get f(){
    return this.ministryLoginForm.controls;
  }

  onSubmit(){
   // alert("ok");
    if(this.ministryLoginForm.controls.username.value==this.user)
    {
      if(this.ministryLoginForm.controls.password.value==this.pass)
      {
        this.router.navigate(['/officerDashboard']);
      }
      else{
        alert("Invalid Credentials");
      }
    }
    
    if(this.ministryLoginForm.invalid){
      return;
    }
  }

}
