import { Component, OnInit } from '@angular/core';
import { Request } from '../request';
import { RequestService } from '../request.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Service } from '../service'; 
import { VehicleService } from '../vehicle.service'; 


@Component({
  selector: 'app-make-request',
  templateUrl: './make-request.component.html',
  styleUrls: ['./make-request.component.css']
})
export class MakeRequestComponent implements OnInit{

  request: Request = new Request();

  services?: Service[];


  constructor(private requestService: RequestService, private router: Router, private http: HttpClient, private vehicleService: VehicleService) { }

  ngOnInit(): void {
    this.getServices();

  }

  getServices() {
    this.vehicleService.getServices().subscribe(
      data => {
        this.services = data;
      }
    );
  }

 
  saveRequest() {
    this.requestService.createRequest(this.request).subscribe(
      data => {
        console.log(data);
        this.requestSentConfirmation();
      },
      error => {
        console.log(error);
      }
    );
  }

  requestSentConfirmation() {
    this.router.navigate(['request-sent']);
  }

  onSubmit() {
    console.log(this.request);
    this.saveRequest();
  }
}
