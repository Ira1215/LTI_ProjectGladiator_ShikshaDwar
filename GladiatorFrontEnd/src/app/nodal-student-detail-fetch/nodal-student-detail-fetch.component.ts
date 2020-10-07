import { Component, OnInit } from '@angular/core';
import { StudentRegistrationService } from '../student-registration.service';
import { StudentApplication } from '../studentapplication';
import { StudentRegistration } from '../StudentRegistration';

@Component({
  selector: 'app-nodal-student-detail-fetch',
  templateUrl: './nodal-student-detail-fetch.component.html',
  styleUrls: ['./nodal-student-detail-fetch.component.css']
})
export class NodalStudentDetailFetchComponent implements OnInit {

  constructor(private service:StudentRegistrationService) { }

  AllStudent:StudentRegistration[];
  ngOnInit(): void {


    this.service.getAll().subscribe(data=>{
      this.AllStudent = data;
    })


  }

// this.app.student10PassingYear 
// this.app.student10Percent 
// this.app.student12RollNo 
// this.app.student12Board 
// this.app.student12PassingYear 
// this.app.student12Percent 
// this.app.disability 
// this.app.disabilityType 
// this.app.disabilityPercentage 
// this.app.studentMaritalStatus 
// this.app.parentProfession 
// this.app.domicileCertificate 
// this.app.studentPhotograph 
// this.app.instituteIdCard 
// this.app.incomeCertificate 
// this.app.previousYearMarksheet 
// this.app.bankPassbook 
// this.app.feeReceipt 
// this.app.aadharCard 
// this.app.markSheet10 
// this.app.markSheet12 
// this.app.scholarshipType 
// this.app.bonafideCertificate 

  }
msg:string;

  accept(){
this.msg = "ACCEPTED"


  }

  reject(){
this.msg = "REJECTED"
  }

}
