import { StudentapplicationService } from './../studentapplication.service';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { StudentApplication } from '../studentapplication';

@Component({
  selector: 'app-student-scholarship-form',
  templateUrl: './student-scholarship-form.component.html',
  styleUrls: ['./student-scholarship-form.component.css']
})
export class StudentScholarshipFormComponent implements OnInit {

  form:FormGroup
  studentApp:StudentApplication[]; //array to store the fetched values 
  exists:boolean=false;

constructor(private service:StudentapplicationService)
{

}/* 

  form=new FormGroup(
    {
      aadharNo: new FormControl('',Validators.required),
      fatherName: new FormControl('',Validators.required),
      motherName: new FormControl('',Validators.required),
      community: new  FormControl('',Validators.required),
      familyIncome:new FormControl('',Validators.required),
      presentCourse:new FormControl('',Validators.required),
      presentCourseYear:new FormControl('',Validators.required)

    });
 */
    

  ngOnInit(): void {

    
    
  this.form=new FormGroup(
    {
      studentName:new FormControl('',Validators.required),
      studentAadharNo: new FormControl('',Validators.required),
      studentFatherName: new FormControl('',Validators.required),
      studentMotherName: new FormControl('',Validators.required),
      studentCategory: new  FormControl('',Validators.required),
      studentReligion:new FormControl('',Validators.required),
      studentFamilyIncome:new FormControl('',Validators.required),
      studentCourse:new FormControl('',Validators.required),
      presentCourseYear:new FormControl('',Validators.required),
      courseStartDate:new FormControl('',Validators.required),
      modeOfStudy:new FormControl('',Validators.required),
      studentPrevCourse:new FormControl('',Validators.required),
      studentPrevPassingYear:new FormControl('',Validators.required),
      studentPrevPercent:new FormControl('',Validators.required),
      student10RollNo:new FormControl('',Validators.required),
      student10BoardName:new FormControl('',Validators.required),
      student10PassingYear:new FormControl('',Validators.required),
      student10Percent:new FormControl('',Validators.required),
      student12RollNo: new  FormControl('',Validators.required),
      student12BoardName:new FormControl('',Validators.required),
      student12PassingYear: new FormControl('',Validators.required),
      student12Percent: new FormControl('',Validators.required),
      tuitionFee:new FormControl('',Validators.required),
      admissionFee:new FormControl('',Validators.required),
      otherFee:new FormControl('',Validators.required),
      bankName: new FormControl('',Validators.required),
      bankAccountNo:new FormControl('',Validators.required),
      bankIfscCode:new FormControl('',Validators.required),
      disabilityType:new FormControl('',Validators.required),
      disability:new FormControl('',Validators.required),
      disabilityPercentage:new FormControl('',Validators.required),
      parentProfession:new FormControl('',Validators.required),
      state:new FormControl('',Validators.required),
      district:new FormControl('',Validators.required),
      blockNo:new FormControl('',Validators.required),
      houseNo:new FormControl('',Validators.required),
      streetNo:new FormControl('',Validators.required),
      pinCode:new FormControl('',Validators.required),
      scholarshipType:new FormControl('',Validators.required),
      studentMaritalStatus:new FormControl('',Validators.required),

      domicileCertificate:new FormControl('',Validators.required),
      studentPhotograph:new FormControl('',Validators.required),
      instituteIdCard:new FormControl('',Validators.required),
      incomeCertificate:new FormControl('',Validators.required),
      previousYearMarkSheet:new FormControl('',Validators.required),
      bankPassbook:new FormControl('',Validators.required),
      feeReceipt:new FormControl('',Validators.required),
      aadharCard:new FormControl('',Validators.required),
      markSheet10:new FormControl('',Validators.required),
      markSheet12:new FormControl('',Validators.required)








    });
   // alert(this.studentApp);
   //fetching all the data using the service and adding it to array we just defined
   this.service.getAllUsers().subscribe(data =>{this.studentApp=data});
  }
  addStudent()
  {
      alert("the flow of control is here!!");
      
    //alert(this.form.controls.studentAadharNo.value);

    let student:StudentApplication=new StudentApplication(this.form.controls.studentName.value,this.form.controls.studentAadharNo.value,this.form.controls.studentFatherName.value,
    this.form.controls.district.value,this.form.controls.state.value,this.form.controls.blockNo.value,
    this.form.controls.streetNo.value,this.form.controls.houseNo.value,this.form.controls.pinCode.value,
    this.form.controls.tuitionFee.value,this.form.controls.admissionFee.value,
    this.form.controls.otherFee.value,this.form.controls.bankName.value,this.form.controls.bankAccountNo.value,
    this.form.controls.bankIfscCode.value,this.form.controls.studentReligion.value,
    this.form.controls.studentCategory.value,this.form.controls.studentMotherName.value,
    this.form.controls.studentFamilyIncome.value,this.form.controls.studentCourse.value,
    this.form.controls.presentCourseYear.value,this.form.controls.modeOfStudy.value,
    this.form.controls.courseStartDate.value,this.form.controls.studentPrevCourse.value,
    this.form.controls.studentPrevPassingYear.value,this.form.controls.studentPrevPercent.value,
    this.form.controls.student10RollNo.value,this.form.controls.student10BoardName.value,
    this.form.controls.student10PassingYear.value,this.form.controls.student10Percent.value,
    this.form.controls.student12RollNo.value,this.form.controls.student12BoardName.value,
    this.form.controls.student12PassingYear.value,this.form.controls.student12Percent.value,
    this.form.controls.disability.value,this.form.controls.disabilityType.value,
    this.form.controls.disabilityPercentage.value,this.form.controls.studentMaritalStatus.value,
    this.form.controls.parentProfession.value,this.form.controls.scholarshipType.value,
    this.form.controls.domicileCertificate.value,this.form.controls.studentPhotograph.value,
    this.form.controls.instituteIdCard.value,this.form.controls.incomeCertificate.value,
    this.form.controls.previousYearMarkSheet.value,this.form.controls.bankPassbook.value,
    this.form.controls.feeReceipt.value,this.form.controls.aadharCard.value,this.form.controls.markSheet10.value,
    this.form.controls.markSheet12.value);  
 
    //console.log(student);
    alert(this.form.controls.studentAadharNo.value);
    this.service.addUser(student).subscribe( data => this.studentApp.push(student));
    /*  for(let s of this.studentApp)
    {
      
      //checking whether the current entered aadhar number is having a match in the array
      if(s.studentAadharNo==student.studentAadharNo)
      { 
        this.exists=true;
        alert("User already Exists");
      }
      
    }
    if(!this.exists){
      this.service.addUser(student).subscribe( data => this.studentApp.push(student));
    } 
       
 */


  }
}
