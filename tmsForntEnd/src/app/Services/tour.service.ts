import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tour } from '../modules/Tour';

@Injectable({
  providedIn: 'root'
})
export class TourService {

  baseURL: String = "http://localhost:8080/tour/";

  constructor(private httpClient: HttpClient) { }

  getTourList(): Observable<Tour[]> {
    return this.httpClient.get<Tour[]>(this.baseURL+"getAllTours");
  }

  findTourById(tourId:number): Observable<Tour> {
    return this.httpClient.get<Tour>(this.baseURL+"findTourById/"+`${tourId}`);
  }

  addTour(tour: Tour):Observable<Tour>{
    return this.httpClient.post<Tour>(this.baseURL+"addTour",tour);
  }

  updateTour(tourId: number, tour: Tour): Observable<Object>{
    return this.httpClient.put(this.baseURL+"updateTour/"+`${tourId}`,tour);
  }
  deleteTour(tourId: number):Observable<object> {
    return this.httpClient.put(this.baseURL+"delete/"+`${tourId}`,null);
  }


}
