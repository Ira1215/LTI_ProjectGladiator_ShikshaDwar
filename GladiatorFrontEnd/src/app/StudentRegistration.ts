export class StudentRegistration{
    studentAadharNo:string;
    studentName:string;
    studentGender:string;
    studentMobile:string;
    studentDob:Date;
    studentInstitution:string;
    studentEmailId:string;
    instituteCode:string;

    constructor(studentAadharNo:string,studentName:string,studentGender:string,
        studentMobile:string,studentInstitution:string,studentDob:Date,studentEmailId:string,instituteCode:string)
    {
        this.studentAadharNo=studentAadharNo;
        this.studentName=studentName;
        this.studentGender=studentGender;
        this.studentMobile=studentMobile;
        this.studentDob=studentDob;
        this.studentInstitution=studentInstitution;
        this.studentEmailId=studentEmailId;
        this.instituteCode=instituteCode;

    }
}