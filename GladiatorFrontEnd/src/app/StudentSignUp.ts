export class StudentSignup{
    studentEmailId:string;
    studentPassword:string;

    constructor(studentEmailId:string,studentPassword:string)
    {
        this.studentEmailId=studentEmailId;
        this.studentPassword=studentPassword;
    }
}