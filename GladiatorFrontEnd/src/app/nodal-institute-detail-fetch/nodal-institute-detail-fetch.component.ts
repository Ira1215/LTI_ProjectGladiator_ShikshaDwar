import { Component, OnInit } from '@angular/core';
import { InstituteLogin } from '../institute';
import { InstituteRegisteredService } from '../institute-registered.service';
import { InstitutesRegistered } from '../instituteRegister';

@Component({
  selector: 'app-nodal-institute-detail-fetch',
  templateUrl: './nodal-institute-detail-fetch.component.html',
  styleUrls: ['./nodal-institute-detail-fetch.component.css']
})
export class NodalInstituteDetailFetchComponent implements OnInit {


  inst:InstituteLogin[];
  inst1:InstitutesRegistered;
  constructor(private service:InstituteRegisteredService) { }

  ngOnInit(): void {

    this.service.getAllinstitutes().subscribe(data=>{
      this.inst = data;
    });


  }


  view(code){
    
this.service.getInstitutesByCode(code).subscribe(data=>{
  this.inst1 = data;
  this.acceptmsg = null;
})

  }



  acceptmsg;
accept(inst1 , code){
this.acceptmsg = "APPROVED"
  // this.service.getApproved(inst1 ,code ).subscribe(data=>{})
}


reject(){
this.acceptmsg = "REJECTED"
 
}


}
