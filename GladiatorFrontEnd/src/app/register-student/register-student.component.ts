import { StudentRegistration } from './../StudentRegistration';
import { StudentRegistrationService } from './../student-registration.service';
import { StudentsignupService } from './../StudentSignup.service';
import { StudentSignup } from './../StudentSignUp';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register-student',
  templateUrl: './register-student.component.html',
  styleUrls: ['./register-student.component.css']
})
export class RegisterStudentComponent implements OnInit {
  studentRegisterForm: FormGroup;
  submitted = false;
  isExist=false;

  constructor(private formBuilder: FormBuilder,private router:Router,private service:StudentRegistrationService) { }

  ngOnInit(): void {
    this.studentRegisterForm = this.formBuilder.group({
      studentName: ['', Validators.required],
      studentAadharNo: ['', Validators.required],
      studentMobileNo: ['', Validators.required],
      studentGender: ['', Validators.required],
      studentDob: ['', Validators.required],
      studentInstitution: ['', Validators.required]
    })
    this.service.getAllUsers().subscribe(data =>{this.registeredStudents=data});

  }
  
  // convenience getter for easy access to form fields
  get reg(){
    return this.studentRegisterForm.controls;
  }

  registeredStudents:StudentRegistration[];


  onSubmit(){
    alert(this.studentRegisterForm.controls.studentGender.value);

    this.submitted = true;
     let student:StudentRegistration=new StudentRegistration(this.studentRegisterForm.controls.studentName.value,
      this.studentRegisterForm.controls.studentAadharNo.value,
      this.studentRegisterForm.controls.studentGender.value,
      this.studentRegisterForm.controls.studentMobileNo.value,
      this.studentRegisterForm.controls.studentDob.value,
      this.studentRegisterForm.controls.studentInstitution.value); 
    //  alert(this.form.controls.fatherName.value);
      for(let rs of this.registeredStudents)
      {
        if(rs.studentAadharNo==student.studentAadharNo)
        {
          alert("first If");
          this.isExist=true;
          this.router.navigate(['/']);
        }
      }
      if(!this.isExist)
      { 
        alert("outside For");
        this.service.addUser(student).subscribe( data => this.registeredStudents.push(student));
        this.router.navigate(['/']);
      }
    
    if(this.studentRegisterForm.invalid){
      return;
    }
  }

  onReset(){
    this.submitted = false;
    this.studentRegisterForm.reset();
  }

}
