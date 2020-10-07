import { InstitutesRegistered } from './instituteRegister';

    export class InstituteLogin{
    diseCode:string;
    instituePassword:string;
    institute: InstitutesRegistered;

    constructor(diseCode:string,instituePassword:string)
    {
        this.diseCode=diseCode;
        this.instituePassword=instituePassword;
    }

}