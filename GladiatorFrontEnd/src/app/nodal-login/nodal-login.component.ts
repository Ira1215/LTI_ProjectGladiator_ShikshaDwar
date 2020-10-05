import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-nodal-login',
  templateUrl: './nodal-login.component.html',
  styleUrls: ['./nodal-login.component.css']
})
export class NodalLoginComponent implements OnInit {
  nodalLoginForm: FormGroup;
  submitted = false;
  
  

  constructor(private formBuilder:FormBuilder,private router:Router) { }

  ngOnInit(): void { 
    this.nodalLoginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required] 
    })
  }

  get f(){
    return this.nodalLoginForm.controls;
  }

  onSubmit(){
alert("ok");
    localStorage.setItem("nodalUserLoginName",this.nodalLoginForm.controls.username.value);
    this.router.navigate(['/officerDashboard']);

    /* if(this.nodalLoginForm.controls.username.value==this.user)
    {
      if(this.nodalLoginForm.controls.password.value==this.pass)
      {
        this.router.navigate(['/officerDashboard']);
      }
      else{
        alert("Invalid Credentials");
      }
    } */
    if(this.nodalLoginForm.invalid){
      return;
    }
  }
}

