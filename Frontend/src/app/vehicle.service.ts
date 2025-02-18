import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Service } from './service';

@Injectable({
  providedIn: 'root'
})

export class VehicleService {

    private baseURL = "http://localhost:8082/api/v1/services";

    constructor(private httpClient: HttpClient) { }

    getServices(): Observable<Service[]> {
      return this.httpClient.get<Service[]>(`${this.baseURL}`);
    }
  
}
