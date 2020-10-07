import { InstituteRegisteredService } from './institute-registered.service';
import { InstitutesRegistered } from './instituteRegister';
import { StudentApplication } from './studentapplication';
import { StudentSignup } from './StudentSignUp';

export class StudentRegistration{
    studentAadharNo:string;
    studentName:string;
    studentGender:string;
    studentMobile:string;
    studentDob:Date;
    studentInstitution:string;
    login:StudentSignup;
    application:StudentApplication;

    constructor(studentAadharNo:string,studentName:string,studentGender:string,
        studentMobile:string,studentInstitution:string,studentDob:Date)
    {
        this.studentAadharNo=studentAadharNo;
        this.studentName=studentName;
        this.studentGender=studentGender;
        this.studentMobile=studentMobile;
        this.studentDob=studentDob;
        this.studentInstitution=studentInstitution;

    }
}