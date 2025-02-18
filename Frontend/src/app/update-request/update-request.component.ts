import { Component, OnInit } from '@angular/core';
import { RequestService } from '../request.service';
import { Request } from '../request';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-update-request',
  templateUrl: './update-request.component.html',
  styleUrls: ['./update-request.component.css']
})
export class UpdateRequestComponent implements OnInit {

  id: number;
  request: Request = new Request();

  constructor(
    private requestService: RequestService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.requestService.getRequestById(this.id).subscribe(
      data => {
        this.request = data;
      },
      error => {
        console.log(error);
      }
    );
  }

  onSubmit() {
    this.requestService.updateRequest(this.id, this.request).subscribe(
      data => {
        this.goToRequestList();
      },
      error => {
        console.log(error);
      }
    );
  }

  goToRequestList() {
    this.router.navigate(['/requests']);
  }
}



