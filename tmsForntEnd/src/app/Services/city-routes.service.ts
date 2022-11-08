import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CityRoutes } from '../modules/CityRoutes';

@Injectable({
  providedIn: 'root'
})
export class CityRoutesService {

  baseURL: String = "http://localhost:8080/cityRoute/";

  constructor(private httpClient: HttpClient) { }

  findAllRoutes(): Observable<CityRoutes[]> {
    return this.httpClient.get<CityRoutes[]>(this.baseURL+"findAllRoutes");
  }

  findRouteById(cityRouteId:number): Observable<CityRoutes> {
    return this.httpClient.get<CityRoutes>(this.baseURL+"findRouteById/"+`${cityRouteId}`);
  }

  addRoutes(cityRoute: CityRoutes):Observable<CityRoutes>{
    return this.httpClient.post<CityRoutes>(this.baseURL+"addRoutes",cityRoute);
  }

  updateRoute(cityRouteId: number, cityRoutes: CityRoutes): Observable<Object>{
    return this.httpClient.put(this.baseURL+"updateRoute/"+`${cityRouteId}`,cityRoutes);
  }
  deleteRoute(cityRouteId: number):Observable<object> {
    return this.httpClient.put(this.baseURL+"deleteRoute/"+`${cityRouteId}`,null);
  }
}
