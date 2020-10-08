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
  
app:StudentApplication;
bcc;
b;
c;
d;
e;
f;
g;
h;
i;
j;
k;
l;
m;
n;
o;
p;
q;
r;
s;
t;
u;
v;
w;
x;
y;
z;


  view(a){
    this.msg = null;
this.app = a;
this.bcc = this.app;
this.b = this.app.studentName;
this.c = this.app.studentName 
this.d = this.app.state 
this.e =this.app.district 
this.f =this.app.blockNo 
this.g =this.app.streetNo 
this.h = this.app.houseNo 
this.i =this.app.pinCode 
this.j= this.app.tuitionFee 
this.h = this.app.admissionFee 
this.i = this.app.otherFee 
this.j= this.app.bankName 
this.k = this.app.bankAccountNo 
this.l =this.app.bankIfscCode 

this.m = this.app.studentReligion 
this.n= this.app.studentCategory 
this.o= this.app.studentFatherName 
this.p =this.app.studentMotherName 
this.q= this.app.studentFamilyIncome 
this.r= this.app.studentCourse 
this.s= this.app.studentYear 
this.t= this.app.modeOfStudy 
this.u= this.app.courseStartDate 
this.v= this.app.studentPrevCourse 
this.w= this.app.studentPrevPassingYear 
this.x= this.app.studentPrevPercent 
this.y= this.app.student10RollNo 
this.z = this.app.student10BoardName 


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
