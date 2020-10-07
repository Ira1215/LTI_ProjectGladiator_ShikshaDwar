import { Router } from '@angular/router';
import { ForgotUpdatePasswordService } from './../forgot-update-password.service';
import { FormsModule, FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { InstituteLogin } from '../institute';
import { InstituteRegisteredService } from '../institute-registered.service';


@Component({
  selector: 'app-officer-dashboard',
  templateUrl: './officer-dashboard.component.html',
  styleUrls: ['./officer-dashboard.component.css']
})
export class OfficerDashboardComponent implements OnInit {

  
  showForgotdiv:boolean=false;
  adminLogin;
  updateValues;

  inst:InstituteLogin[];

  updatePasswordForm:FormGroup; 

  constructor(private updateService:ForgotUpdatePasswordService,private fb:FormBuilder,private router:Router) { }

  ngOnInit(): void {
   this.updatePasswordForm=this.fb.group({
    newPassword:['',Validators.required],
    confirmPassword:['',Validators.required]

   })






console.log(this.inst)


    
  }
  

  

updatePassword()
{

 
  this.showForgotdiv=!this.showForgotdiv;

}

submitPassword()
{
  
  this.adminLogin={username:localStorage.getItem("nodalUserLoginName"),password:this.updatePasswordForm.controls.newPassword.value}
  this.updateService.updatePassword(localStorage.getItem("nodalUserLoginName"),this.adminLogin).subscribe(data=>{this.updateValues.push(this.adminLogin)});
  alert("Your Password Was Successfully Changed");
  this.router.navigate(['/']);
}



}
