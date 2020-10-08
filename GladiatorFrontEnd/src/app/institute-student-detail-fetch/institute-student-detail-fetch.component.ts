import { StudentApplication } from './../studentapplication';
import { InstituteService } from './../institute.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-institute-student-detail-fetch',
  templateUrl: './institute-student-detail-fetch.component.html',
  styleUrls: ['./institute-student-detail-fetch.component.css']
})
export class InstituteStudentDetailFetchComponent implements OnInit {

  constructor(private fetchService:InstituteService) { }

  studentScholarShipDetails:StudentApplication[];
  code=localStorage.getItem("instCodeFetchStudDetails");
  ngOnInit(): void {

    alert(this.code);
    this.fetchService.getStudentDetailsByInstCode(this.code).subscribe(data=>{
      this.studentScholarShipDetails=data;
    }
    )
    alert(this.studentScholarShipDetails);

  
    }


}
