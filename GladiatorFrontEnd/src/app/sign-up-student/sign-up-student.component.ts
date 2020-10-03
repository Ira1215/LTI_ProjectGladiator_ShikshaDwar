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
  submitted= false;
  isExist=false;
  

  constructor(private formBuilder: FormBuilder,private service:StudentsignupService,private router:Router) {}
  ngOnInit(): void {
    this.signUpStudentForm = this.formBuilder.group({
      studentEmailId: ['', Validators.required],
      studentPassword: ['', Validators.required],
      cPassword: ['', Validators.required],
    });
    this.service.getAllUsers().subscribe(data =>{this.studentData=data});
  }

  get signUp() {
    return this.signUpStudentForm.controls;
  }

  studentData:StudentSignup[];

  onSubmit() {
    alert(this.signUpStudentForm.controls.studentEmailId.value);
    alert(this.signUpStudentForm.controls.studentPassword.value);
    this.submitted= true;
    let student:StudentSignup=new StudentSignup(this.signUpStudentForm.controls.studentEmailId.value,
      this.signUpStudentForm.controls.studentPassword.value);
      this.service.addUser(student).subscribe( data => this.studentData.push(student));
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

    if (this.signUpStudentForm.invalid) {
      return;
    }
  }
}
