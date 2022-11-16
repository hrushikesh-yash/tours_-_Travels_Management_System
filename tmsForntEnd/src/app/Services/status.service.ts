import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Status } from '../modules/Status';

@Injectable({
  providedIn: 'root'
})
export class StatusService {

  baseURL: String = "http://localhost:8080/status/";

  constructor(private httpClient: HttpClient) { }

  // getTourList(): Observable<Tour[]> {
  //   return this.httpClient.get<Tour[]>(this.baseURL+"getAllTours");
  // }

  findStatusByName(statusName:string): Observable<Status> {
    return this.httpClient.get<Status>(this.baseURL+"getStatusByName/"+`${statusName}`);
  }

  // addTour(tour: Tour):Observable<Tour>{
  //   return this.httpClient.post<Tour>(this.baseURL+"addTour",tour);
  // }

  // updateTour(tourId: number, tour: Tour): Observable<Object>{
  //   return this.httpClient.put(this.baseURL+"updateTour/"+`${tourId}`,tour);
  // }
  // deleteTour(tourId: number):Observable<object> {
  //   return this.httpClient.put(this.baseURL+"delete/"+`${tourId}`,null);
  // }


}


