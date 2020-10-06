import { Router } from '@angular/router';
import { ForgotUpdatePasswordService } from './../forgot-update-password.service';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ministry-dashboard',
  templateUrl: './ministry-dashboard.component.html',
  styleUrls: ['./ministry-dashboard.component.css']
})
export class MinistryDashboardComponent implements OnInit {

  showForgotdiv:boolean=false;
  adminLogin;
  updateValues;



  updatePasswordForm:FormGroup; 

  constructor(private updateService:ForgotUpdatePasswordService,private fb:FormBuilder,private router:Router) { }

  ngOnInit(): void {
   this.updatePasswordForm=this.fb.group({
    newPassword:['',Validators.required],
    confirmPassword:['',Validators.required]

   })
    
  }
  

  

updatePassword()
{

  alert("ok");
  this.showForgotdiv=!this.showForgotdiv;

}

submitPassword()
{
  
  this.adminLogin={username:"admin",password:this.updatePasswordForm.controls.newPassword.value}
  this.updateService.updatePassword(("admin"),this.adminLogin).subscribe(data=>{this.updateValues.push(this.adminLogin)});
  alert("Your Password Was Successfully Changed");
  this.router.navigate(['/']);
}

}
