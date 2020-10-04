import { InstitutesRegistered } from './../instituteRegister';
import { InstituteRegisteredService } from './../institute-registered.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-institute-application',
  templateUrl: './institute-application.component.html',
  styleUrls: ['./institute-application.component.css'],
})
export class InstituteApplicationComponent implements OnInit {
  instituteApplicationForm: FormGroup;
  submitted = false;
  institutesRegistered:InstitutesRegistered[];
  exists:boolean=false;

  constructor(private formBuilder: FormBuilder,private router:Router,private service:InstituteRegisteredService) {}

  ngOnInit(): void {
    this.instituteApplicationForm = this.formBuilder.group({
      instituteCode:['', Validators.required],
      instituteName:['', Validators.required],
      instituteCategory:['', Validators.required],
      instituteLocation:['', Validators.required],
      instituteType:['', Validators.required],
      affiliatedUniState:['', Validators.required],
      affiliatedUniboard:['', Validators.required],
      yearAdmissionStarted:['', Validators.required],
      uniAffiliationCerti:['', Validators.required],
      instituteEstbCerti:['', Validators.required],
      addressLine1:['', Validators.required],
      addressLine2:['', Validators.required],
      instituteState:['', Validators.required],
      district:['', Validators.required],
      city:['', Validators.required],
      pincode:['', Validators.required],
      instituteHeadName:['', Validators.required],
      instituteHeadContact:['', Validators.required],
      diseCode:['', Validators.required],
    });
    this.service.getAllUsers().subscribe(data =>{this.institutesRegistered=data});
  }

  get instApp(){
    return this.instituteApplicationForm.controls;
  }

 

  instituteDetails:InstitutesRegistered;
  

  onSubmit() {

    alert(this.instituteApplicationForm.controls.diseCode.value);

    this.instituteDetails= new InstitutesRegistered(this.instituteApplicationForm.controls.instituteCode.value,
      this.instituteApplicationForm.controls.instituteName.value,this.instituteApplicationForm.controls.instituteCategory.value,
      this.instituteApplicationForm.controls.instituteLocation.value,
      this.instituteApplicationForm.controls.instituteType.value,
      this.instituteApplicationForm.controls.affiliatedUniState.value,
      this.instituteApplicationForm.controls.affiliatedUniboard.value,
      this.instituteApplicationForm.controls.yearAdmissionStarted.value,
      this.instituteApplicationForm.controls.uniAffiliationCerti.value,
      this.instituteApplicationForm.controls.instituteEstbCerti.value,
      this.instituteApplicationForm.controls.addressLine1.value,
      this.instituteApplicationForm.controls.addressLine2.value,
      this.instituteApplicationForm.controls.instituteState.value,
      this.instituteApplicationForm.controls.district.value,
      this.instituteApplicationForm.controls.city.value,
      this.instituteApplicationForm.controls.pincode.value,
      this.instituteApplicationForm.controls.instituteHeadName.value,
      this.instituteApplicationForm.controls.instituteHeadContact.value,
      this.instituteApplicationForm.controls.diseCode.value
    );

    this.service.addUser(this.instituteDetails).subscribe( data => this.institutesRegistered.push(this.instituteDetails));
/* 
    for(let s of this.institutesRegistered)
    {
      
      if(s.diseCode==this.instituteDetails.diseCode)
      { 
        this.exists=true;
        alert("Institute already Exists");
      }
      
    }
    if(!this.exists){
      this.service.addUser(this.instituteDetails).subscribe( data => this.institutesRegistered.push(this.instituteDetails));
    }  



     this.router.navigate(['/']);
    this.submitted = true;
    if (this.instituteApplicationForm.invalid) {
      return;
    }
  }

  onReset(){
    this.submitted=false;
    this.instituteApplicationForm.reset();
  } */

}
}
