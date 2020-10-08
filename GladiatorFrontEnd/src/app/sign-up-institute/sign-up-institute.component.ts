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
  //   this.service.getAllUsers().subscribe(data =>{this.instituteData=data});
  }

  // convenience getter for easy access to form fields
  get signUp(){
    return this.signUpInstituteForm.controls;
  }


  onSubmit(){
  
    this.submitted = true;
    let u:InstituteLogin=new InstituteLogin(this.signUpInstituteForm.controls.diseCode.value,
      this.signUpInstituteForm.controls.institutePassword.value); 

      alert("button working");
      this.service.addInstitute(u).subscribe(u =>{
        alert(u.status);
        if(u.status=="SUCCESS")
        {
          alert("ok")
          localStorage.setItem("signedupInstitute",this.signUpInstituteForm.controls.diseCode.value );
          this.router.navigate(['/instituteRegistrationForm'])
        }
        else{
          alert("not ok")
          this.router.navigate(['/'])
        } 
      }
      )
      // this.service.addInstitute(u).subscribe(u => {
      //   alert(u.status)
      //   if (u.status == "SUCCESS") {
      //     alert("REGISTRATION SUCCESSFUL");
      //     localStorage.setItem("signedupInstitute",this.signUpInstituteForm.controls.diseCode.value );
      //     setTimeout(function () {
      //       window.location.href = 'instituteRegistrationForm';
      //     }, 200);
      //   }
      //   else {
      //     alert("THIS dise code IS ALREADY REGISTERED");
      //     setTimeout(function () {
      //       window.location.href = '/';
      //     }, 200);
      //   }
      // })
  
      // }
        
    }
    
  }










        
      //   this.service.addInstitute(institute).subscribe( institute=>{
    //     if (institute.status =="SUCCESS") {
    //       alert("REGISTRATION SUCCESSFUL");
    //       setTimeout(function () {
    //         window.location.href = 'instituteRegistrationForm';
    //       }, 200);
    //     }
    //     else {
    //       alert("THIS EMAIL ID IS ALREADY REGISTERED");
    //       setTimeout(function () {
    //         window.location.href = '/';
    //       }, 200);
    //     }
    //   })
    // }
     
      /* for(let i of this.instituteData)
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
    } */