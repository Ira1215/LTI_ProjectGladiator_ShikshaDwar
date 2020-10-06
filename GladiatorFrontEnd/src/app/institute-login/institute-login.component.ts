import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { InstituteService } from './../institute.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { InstituteLogin } from '../institute';

@Component({
  selector: 'app-institute-login',
  templateUrl: './institute-login.component.html',
  styleUrls: ['./institute-login.component.css']
})
export class InstituteLoginComponent implements OnInit {

  form:FormGroup;
 
  flag:boolean=false;
  error:boolean=false;
 

  constructor(private service:InstituteService,private router:Router)
  {

  }


  ngOnInit(): void {

   
   this.form=new FormGroup(
      {
        diseCode: new FormControl('',[Validators.required, Validators.maxLength(11)]),
        institutePassword: new FormControl('',Validators.required)
      });

      }

     
        
    onLogin()
    { 
 

 
    let inst:InstituteLogin = new InstituteLogin(this.form.controls.diseCode.value , this.form.controls.institutePassword.value);
    alert("login")
   

    this.router.navigate(['/instituteDashboard']);
      
      /* for(let i of this.instituteLogin)
      { 
       // alert(i.diseCode);
          if(i.diseCode==diseCode)
          { 
            this.flag=true;
           // alert(i.institutePassword);
            if(i.institutePassword==password)
            {

            this.router.navigate(['/instituteDashboard']);
            }
            else{
              alert("invalid Credentials");
            }
          }
          
      }

      if(this.flag==false)
      {
        this.error=true;
        alert("You are Not a Registered Institute Register yourself First");
      }
 */

    }

  }

  


