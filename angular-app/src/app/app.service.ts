import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { App } from './app';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) {}

  //Headers
  httpOptions = {
    headers: new HttpHeaders(
      {
        'Content-Type': 'aplication/json'
        
      })
  };

  findAll():Observable<App[]> {
    return this.http.get<App[]>('http://localhost:8080/api/v1/CustomerValidated', );
  }

}
