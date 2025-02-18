import { Component, OnInit  } from '@angular/core';
import { Request } from "../request";
import { RequestService } from '../request.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-request-list',
  templateUrl: './request-list.component.html',
  styleUrls: ['./request-list.component.css']
})
export class RequestListComponent implements OnInit{

  requests?: Request[];

  constructor(private requestService: RequestService, private router: Router) {}

  ngOnInit(): void {
    this.getRequests();
  }

  private getRequests(){
    this.requestService.getRequestsList().subscribe(data => {
      this.requests = data;
    });
  }

  requestDetails(id: number){
    this.router.navigate(['request-details', id]);
  }

  updateRequest(id: number){
    this.router.navigate(['update-request', id]);
  }

  deleteRequest(id: number){
    this.requestService.deleteRequest(id).subscribe( data => {
      console.log(data);
      this.getRequests();
    })
  }
}
