import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-institute-dashboard',
  templateUrl: './institute-dashboard.component.html',
  styleUrls: ['./institute-dashboard.component.css']
})
export class InstituteDashboardComponent implements OnInit {
instDise;
  constructor(private router:Router) { }

  ngOnInit(): void {

    this.instDise = localStorage.getItem("loggedinDise")
   
  }


  logout()
  {
    // localStorage.clear();
     this.router.navigate(['/'])
  }
}
