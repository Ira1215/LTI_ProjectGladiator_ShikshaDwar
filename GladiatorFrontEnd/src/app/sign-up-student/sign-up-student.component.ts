import { UserValidationService } from './../user-validation.service';
import { StudentSignup } from './../StudentSignUp';
import { Router } from '@angular/router';
import { StudentsignupService } from './../StudentSignup.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-sign-up-student',
  templateUrl: './sign-up-student.component.html',
  styleUrls: ['./sign-up-student.component.css'],
})
export class SignUpStudentComponent implements OnInit {
  signUpStudentForm: FormGroup;
  

  

  constructor(private formBuilder: FormBuilder,private service:StudentsignupService,private router:Router,private userValidate:UserValidationService) {}
  ngOnInit(): void {
    this.signUpStudentForm = this.formBuilder.group({
      studentEmailId:['',[Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
      studentPassword:['',Validators.compose([Validators.required,this.userValidate.patternValidator()])],
      cPassword:['', Validators.required],
    },
    {
      validator: this.userValidate.MatchPassword('studentPassword','cPassword'),
    }
    );
  
  }

  get signUp() {
    return this.signUpStudentForm.controls;
  }

  studentData:StudentSignup[];

  onSubmit() {
    alert(this.signUpStudentForm.controls.studentEmailId.value);
    alert(this.signUpStudentForm.controls.studentPassword.value);
   
    let student:StudentSignup=new StudentSignup(this.signUpStudentForm.controls.studentEmailId.value,
      this.signUpStudentForm.controls.studentPassword.value);
      this.service.addUser(student).subscribe( data => this.studentData.push(student));
      this.router.navigate(['/studentRegister']);
    

    if (this.signUpStudentForm.invalid) {
      return;
    }
  }
}
















  /* for(let s of this.studentData)
      {
        if(s.studentEmailId==student.studentEmailId)
        {
          this.isExist=true;
          alert("u have already registered yourself kindly login");
          this.router.navigate(['/studentRegister']);

        }
       
      }
      if(!this.isExist)
        {
          this.service.addUser(student).subscribe( data => this.studentData.push(student));
          this.router.navigate(['/studentRegister']);

        }
 */