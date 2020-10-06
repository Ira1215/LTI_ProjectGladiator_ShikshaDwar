import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student-dashboard',
  templateUrl: './student-dashboard.component.html',
  styleUrls: ['./student-dashboard.component.css']
})
export class StudentDashboardComponent implements OnInit {

  constructor(private router:Router) { }

  user:string;


  ngOnInit(): void {

    this.user=localStorage.getItem("loginEmail");
    alert(this.user)
  
  }
  onLogout()
  {
    sessionStorage.removeItem("signedUpUser");
    this.router.navigate(['/']);

  }

}
