export class StudentRegistration{
    studentAadharNo:string;
    studentName:string;
    studentGender:string;
    studentMobile:string;
    studentInstitution:string;
    studentDob:Date;

    constructor(studentAadharNo:string,studentName:string,studentGender:string,
        studentMobile:string,studentInstitution:string,studentDob:Date)
    {
        this.studentAadharNo=studentAadharNo;
        this.studentName=studentName;
        this.studentGender=studentGender;
        this.studentInstitution=studentInstitution;
        this.studentMobile=studentMobile;
        this.studentDob=studentDob;

    }
}