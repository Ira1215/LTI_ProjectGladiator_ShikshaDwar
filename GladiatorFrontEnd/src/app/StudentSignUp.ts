import { StudentRegistration } from './StudentRegistration';
export class StudentSignup{
    studentEmailId:string;
    studentPassword:string;
    student:StudentRegistration;

    constructor(studentEmailId:string,studentPassword:string)
    {
        this.studentEmailId=studentEmailId;
        this.studentPassword=studentPassword;
    }
}