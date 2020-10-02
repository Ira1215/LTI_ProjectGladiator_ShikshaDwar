import { InstituteRegisteredService } from './institute-registered.service';
import { MinistryInstituteDetailFetchComponent } from './ministry-institute-detail-fetch/ministry-institute-detail-fetch.component';
import { MinistryStudentDetailFetchComponent } from './ministry-student-detail-fetch/ministry-student-detail-fetch.component';
import { NodalInstituteDetailFetchComponent } from './nodal-institute-detail-fetch/nodal-institute-detail-fetch.component';
import { NodalStudentDetailFetchComponent } from './nodal-student-detail-fetch/nodal-student-detail-fetch.component';
import { InstituteStudentDetailFetchComponent } from './institute-student-detail-fetch/institute-student-detail-fetch.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { InstituteService } from './institute.service';
import { StudentapplicationService } from './studentapplication.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import bootstrap from 'bootstrap';
import { InstituteLoginComponent } from './institute-login/institute-login.component';
import { StudentLoginComponent } from './student-login/student-login.component';
import { NodalLoginComponent } from './nodal-login/nodal-login.component';
import { MinistryLoginComponent } from './ministry-login/ministry-login.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { NavbarLandingPageComponent } from './navbar-landing-page/navbar-landing-page.component';
import { SignUpStudentComponent } from './sign-up-student/sign-up-student.component';
import { SignUpInstituteComponent } from './sign-up-institute/sign-up-institute.component';
import { RegisterStudentComponent } from './register-student/register-student.component';
import { StudentScholarshipFormComponent } from './student-scholarship-form/student-scholarship-form.component';
import { StudentDashboardComponent } from './student-dashboard/student-dashboard.component';
import { OfficerDashboardComponent } from './officer-dashboard/officer-dashboard.component';
import { InstituteDashboardComponent } from './institute-dashboard/institute-dashboard.component';
import { MinistryDashboardComponent } from './ministry-dashboard/ministry-dashboard.component';
import { InstituteApplicationComponent } from './institute-application/institute-application.component';
import { StudentTrackApplicationStatusComponent } from './student-track-application-status/student-track-application-status.component';
import { InstituteTrackApplicationStatusComponent } from './institute-track-application-status/institute-track-application-status.component';
import { StudentDashboardNavBarComponent } from './student-dashboard-nav-bar/student-dashboard-nav-bar.component';
import { InstituteDashboardNavBarComponent } from './institute-dashboard-nav-bar/institute-dashboard-nav-bar.component';
import { OfficerDashboardNavBarComponent } from './officer-dashboard-nav-bar/officer-dashboard-nav-bar.component';
import { MinistryDashboardNavBarComponent } from './ministry-dashboard-nav-bar/ministry-dashboard-nav-bar.component';
import { AppRoutingModule } from './app-routing.module'; 
import { HardcodedAuthenticationService } from './service/hardcoded-authentication.service';
import { ErrorComponent } from './error/error.component';


@NgModule({
  declarations: [
    AppComponent,
    InstituteLoginComponent,
    ContactUsComponent,
    MinistryDashboardNavBarComponent,
    StudentLoginComponent,
    NodalLoginComponent,
    MinistryLoginComponent,
    LandingPageComponent,
    AboutUsComponent,
    NavbarLandingPageComponent,
    SignUpStudentComponent,
    SignUpInstituteComponent,
    RegisterStudentComponent,
    StudentScholarshipFormComponent,
    StudentDashboardComponent,
    OfficerDashboardComponent,
    InstituteDashboardComponent,
    MinistryDashboardComponent,
    InstituteApplicationComponent,
    StudentTrackApplicationStatusComponent,
    InstituteTrackApplicationStatusComponent,
    StudentDashboardNavBarComponent,
    InstituteDashboardNavBarComponent,
    OfficerDashboardNavBarComponent,
    MinistryDashboardNavBarComponent,
    ErrorComponent,
    InstituteStudentDetailFetchComponent,
    NodalStudentDetailFetchComponent,
    NodalInstituteDetailFetchComponent,
    MinistryStudentDetailFetchComponent,
    MinistryInstituteDetailFetchComponent 
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  
    
  ],
  providers: [HardcodedAuthenticationService,StudentapplicationService,InstituteService,InstituteRegisteredService],
  bootstrap: [AppComponent]
})
export class AppModule { }
