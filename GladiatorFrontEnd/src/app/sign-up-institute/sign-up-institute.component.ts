import { HttpClient } from '@angular/common/http';
import { InstituteService } from './../institute.service';
import {InstituteLogin} from '../institute';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { from } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up-institute',
  templateUrl: './sign-up-institute.component.html',
  styleUrls: ['./sign-up-institute.component.css']
})
export class SignUpInstituteComponent implements OnInit {
  signUpInstituteForm: FormGroup;
  submitted = false;
  isExisting=false;

  constructor(private formBuilder: FormBuilder,private service:InstituteService,private router:Router) { }

  ngOnInit(): void {
    this.signUpInstituteForm = this.formBuilder.group({
      diseCode:['',  Validators.required],
      institutePassword: ['', Validators.required],
      cPassword: ['', Validators.required]
    })
    this.service.getAllUsers().subscribe(data =>{this.instituteData=data});
  }

  // convenience getter for easy access to form fields
  get signUp(){
    return this.signUpInstituteForm.controls;
  }

   instituteData:InstituteLogin[];

  instituteArray:InstituteLogin[];

  onSubmit(){
  
    this.submitted = true;
    let institute:InstituteLogin=new InstituteLogin(this.signUpInstituteForm.controls.diseCode.value,
      this.signUpInstituteForm.controls.institutePassword.value); 
      for(let i of this.instituteData)
      {
        if(i.diseCode==institute.diseCode)
        {
          this.isExisting=true;
          alert("User Already Exists");
          this.router.navigate(['/instituteRegistrationForm']);

        }
      }
        if(!this.isExisting)
        {
          this.service.addUser(institute).subscribe( data => this.instituteArray.push(institute));
          alert("its entering here!")
          this.router.navigate(['/instituteRegistrationForm']);

        }

      

      //Institute Getting added 
     


    if(this.signUpInstituteForm.invalid){
      return; 
    }
  }
}

