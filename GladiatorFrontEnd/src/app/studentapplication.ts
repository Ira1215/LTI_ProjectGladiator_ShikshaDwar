import { StudentRegistration } from './StudentRegistration';
export class StudentApplication{
    studentApplicationNo:number;
    studentName:string;
    
    //studentAadharNo:string;
    studentFatherName:string;
    state:string;
    district:string;
    blockNo:string; //changed
    streetNo:number;
    houseNo:number;
    pinCode:string;
    tuitionFee:number;
    admissionFee:number;
    otherFee:number;
    bankName:string;
    bankAccountNo:string;
    bankIfscCode:string;
    studentReligion:string;
    studentCategory:string;
    studentMotherName:string;
    studentFamilyIncome:string;
    studentCourse:string;
    studentYear:number;
    modeOfStudy:string;
    courseStartDate:Date;
    studentPrevCourse:string;
    studentPrevPassingYear:number;
    studentPrevPercent:number;
    student10RollNo:string;
    student10BoardName:string;
    student10PassingYear:number;
    student10Percent:number;
    student12RollNo:string;
    student12Board:string;
    student12PassingYear:number;
    student12Percent:number;
    disability:string;
    disabilityType:string;
    disabilityPercentage:number;
    studentMaritalStatus:string;
    parentProfession:string;
    scholarshipType:string
    domicileCertificate:string;
    studentPhotograph:string;
    instituteIdCard:string;
    incomeCertificate:string;
    previousYearMarksheet:string;
    bankPassbook:string;
    feeReceipt:string;
    aadharCard:string;
    markSheet10:string;
    markSheet12:string;
    bonafideCertificate:string;
    applicationStatus:string;
    registration:StudentRegistration;
    

    

    constructor(studentName:string,studentFatherName:string,state:string,district:string,
        blockNo:string,streetNo:number,houseNo:number,pinCode:string,tuitionFee:number,admissionFee:number,
        otherFee:number,bankName:string,bankAccountNo:string,bankIfscCode:string,studentReligion:string,
        studentCategory:string,studentMotherName:string,studentFamilyIncome:string,studentCourse:string,
        studentYear:number,modeOfStudy:string,courseStartDate:Date,studentPrevCourse:string,
        studentPrevPassingYear:number,studentPrevPercent:number,student10RollNo:string,
        student10BoardName:string,student10PassingYear:number,student10Percent:number,
        student12RollNo:string,student12Board:string,student12PassingYear:number,
        student12Percent:number,disability:string,disabilityType:string,disabilityPercentage:number,
        studentMaritalStatus:string,parentProfession:string,scholarshipType:string,domicileCertificate:string,studentPhotograph:string,
        instituteIdCard:string,incomeCertificate:string,previousYearMarksheet:string,
        bankPassbook:string,feeReceipt:string,aadharCard:string,markSheet10:string,markSheet12:string)
    {   
        this.studentName=studentName;
       // this.studentAadharNo=studentAadharNo;
        this.studentFatherName=studentFatherName;
        this.state=state;
        this.district=district;
        this.blockNo=blockNo;
        this.streetNo=streetNo;
        this.houseNo=houseNo;
        this.pinCode=pinCode;
        this.tuitionFee=tuitionFee;
        this.admissionFee=admissionFee;
        this.otherFee=otherFee;
        this.bankName=bankName;
        this.bankAccountNo=bankAccountNo;
        this.bankIfscCode=bankIfscCode;
        this.studentReligion=studentReligion;
        this.studentCategory=studentCategory;
        this.studentMotherName=studentMotherName;
        this.studentFamilyIncome=studentFamilyIncome;
        this.studentCourse=studentCourse;
        this.studentYear=studentYear;
        this.modeOfStudy=modeOfStudy;
        this.courseStartDate=courseStartDate;
        this.studentPrevCourse=studentPrevCourse;
        this.studentPrevPassingYear=studentPrevPassingYear;
        this.studentPrevPercent=studentPrevPercent;
        this.student10RollNo=student10RollNo;
        this.student10BoardName=student10BoardName;
        this.student10PassingYear=student10PassingYear;
        this.student10Percent=student10Percent;
        this.student12RollNo=student12RollNo;
        this.student12Board=student12Board;
        this.student12PassingYear=student12PassingYear;
        this.student12Percent=student12Percent;
        this.disability=disability;
        this.disabilityType=disabilityType;
        this.disabilityPercentage=disabilityPercentage;
        this.studentMaritalStatus=studentMaritalStatus;
        this.parentProfession=parentProfession;
        this.scholarshipType=scholarshipType;

        this.domicileCertificate=domicileCertificate;
        this.studentPhotograph=studentPhotograph;
        this.instituteIdCard=instituteIdCard;
        this.incomeCertificate=incomeCertificate;
        this.previousYearMarksheet=previousYearMarksheet;
        this.bankPassbook=bankPassbook;
        this.feeReceipt=feeReceipt;
        this.aadharCard=aadharCard;
        this.markSheet10=markSheet10;
        this.markSheet12=markSheet12;

    }
}