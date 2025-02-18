import { Component, OnInit } from '@angular/core';
import { Request } from '../request';
import { ActivatedRoute } from '@angular/router';
import { RequestService } from '../request.service';


@Component({
  selector: 'app-request-details',
  templateUrl: './request-details.component.html',
  styleUrls: ['./request-details.component.css']
})
export class RequestDetailsComponent implements OnInit {

  id: number;
  request: Request;

  constructor(
    private route: ActivatedRoute,
    private requestService: RequestService
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.request = new Request();

    this.requestService.getRequestById(this.id).subscribe(
      data => {
        this.request = data;
      },
      error => {
        console.log(error);
      }
    );
  }
}



