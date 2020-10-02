import { SignUpInstituteComponent } from './sign-up-institute/sign-up-institute.component';
import { SignUpStudentComponent } from './sign-up-student/sign-up-student.component';
import { MinistryInstituteDetailFetchComponent } from './ministry-institute-detail-fetch/ministry-institute-detail-fetch.component';
import { MinistryStudentDetailFetchComponent } from './ministry-student-detail-fetch/ministry-student-detail-fetch.component';
import { NodalInstituteDetailFetchComponent } from './nodal-institute-detail-fetch/nodal-institute-detail-fetch.component';
import { NodalStudentDetailFetchComponent } from './nodal-student-detail-fetch/nodal-student-detail-fetch.component';
import { InstituteStudentDetailFetchComponent } from './institute-student-detail-fetch/institute-student-detail-fetch.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { RegisterStudentComponent } from './register-student/register-student.component';
import { ErrorComponent } from './error/error.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { MinistryDashboardComponent } from './ministry-dashboard/ministry-dashboard.component';
import { OfficerDashboardComponent } from './officer-dashboard/officer-dashboard.component';
import { InstituteApplicationComponent } from './institute-application/institute-application.component';
import { InstituteDashboardComponent } from './institute-dashboard/institute-dashboard.component';
import { StudentScholarshipFormComponent } from './student-scholarship-form/student-scholarship-form.component';
import { StudentDashboardComponent } from './student-dashboard/student-dashboard.component';
import { InstituteLoginComponent } from './institute-login/institute-login.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';


const routes:Routes=[{path:'',component:LandingPageComponent},
  {path:'institute',component:InstituteLoginComponent},
  {path:'studentRegistration', component:RegisterStudentComponent},
  { path:'studentDashboard', component:StudentDashboardComponent},
  { path:'studentRegistrationForm', component:StudentScholarshipFormComponent },
  { path:'instituteDashboard', component:InstituteDashboardComponent },
  { path:'instituteRegistrationForm', component: InstituteApplicationComponent },
  { path:'officerDashboard', component: OfficerDashboardComponent },
  { path:'ministryDashboard', component:MinistryDashboardComponent },
  {path:'aboutus',component:AboutUsComponent},
  { path: 'contactus', component: ContactUsComponent },
  {
    path: 'instituteFetchStudent',
    component: InstituteStudentDetailFetchComponent,
  },
  { path: 'nodalFetchStudent', component: NodalStudentDetailFetchComponent },
  {
    path: 'nodalFetchInstitute',
    component: NodalInstituteDetailFetchComponent,
  },
  {
    path: 'ministryFetchStudent',
    component: MinistryStudentDetailFetchComponent,
  },
  {
    path: 'ministryFetchInstitute',
    component: MinistryInstituteDetailFetchComponent,
  },
  { path:'studentSignUp', component: SignUpStudentComponent },
  { path:'instituteSignUp', component: SignUpInstituteComponent },
  { path:'studentRegister', component: RegisterStudentComponent },
  {path:'**',component:ErrorComponent}, 
  
  


]

@NgModule({
  declarations: [],

    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  
})
export class AppRoutingModule { }
