import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Request } from './request';

@Injectable({ 
  providedIn: 'root'
})
export class RequestService {  

  private baseURL = "http://localhost:8082/api/v1/requests";

  constructor(private httpClient: HttpClient) { }

  getRequestsList(): Observable<Request[]> {
    return this.httpClient.get<Request[]>(`${this.baseURL}`);
  }

  createRequest(request: Request): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, request);
  }

  getRequestById(id: number): Observable<Request> {
    return this.httpClient.get<Request>(`${this.baseURL}/${id}`);
  }

  updateRequest(id: number, request: Request): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/${id}`, request);
  }

  deleteRequest(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}



