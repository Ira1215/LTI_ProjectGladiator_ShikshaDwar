import { InstituteLogin } from './institute';
import { StudentRegistration } from './StudentRegistration';

export class InstitutesRegistered{

    instituteCode:string;
    instituteName:string;
    instituteCategory:string;
    instituteLocation:string;
    instituteType:string;
    affiliatedUniState:string;
    affiliatedUniboard:string;
    yearAdmissionStarted:string;
    uniAffiliationCerti:string;
    instituteEstbCerti:string;
    addressLine1:string;
    addressLine2:string;
    instituteState:string;
    district:string;
    city:string;
    pincode:string;
    instituteHeadName:string;
    instituteHeadContact:string;
    registrationStatus:string;
    login:InstituteLogin;
    students:StudentRegistration;



    constructor(instituteCode:string,instituteName:string,instituteCategory:string,instituteLocation:string,
        instituteType:string,affiliatedUniState:string,affiliatedUniboard:string,yearAdmissionStarted:string,
        uniAffiliationCerti:string,instituteEstbCerti:string,addressLine1:string,addressLine2:string,
        instituteState:string,district:string,city:string,pincode:string,instituteHeadName:string,
        instituteHeadContact:string)
                {
                    this.instituteCode=instituteCode;
                    this.instituteName=instituteName;
                    this.instituteCategory=instituteCategory;
                    this.instituteLocation=instituteLocation;
                    this.instituteType=instituteType;
                    this.affiliatedUniState=affiliatedUniState;
                    this.affiliatedUniboard=affiliatedUniboard;
                    this.yearAdmissionStarted=yearAdmissionStarted;
                    this.uniAffiliationCerti=uniAffiliationCerti;
                    this.instituteEstbCerti=instituteEstbCerti;
                    this.addressLine1=addressLine1;
                    this.addressLine2=addressLine2;
                    this.instituteState=instituteState;
                    this.district=district;
                    this.city=city;
                    this.pincode=pincode;
                    this.instituteHeadName=instituteHeadName;
                    this.instituteHeadContact=instituteHeadContact;






                }



        
    

    

}