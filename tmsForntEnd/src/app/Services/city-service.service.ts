import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { City } from '../modules/City';
import {CityList} from '../modules/CityList'
import { State } from '../modules/State';

@Injectable({
  providedIn: 'root'
})
export class CityServiceService {
  

 

  baseURL: String = "http://localhost:8080/city/";

  constructor(private httpClient: HttpClient) { }

  getCityList(): Observable<City[]> {
    return this.httpClient.get<City[]>(this.baseURL+"getAllCities");
  }

  findCityById(cityId:number): Observable<City> {
    return this.httpClient.get<City>(this.baseURL+"findCityById/"+`${cityId}`);
  }

  addCity(city: City):Observable<City>{
    return this.httpClient.post<City>(this.baseURL+"addCity",city);
  }

  updateCity(cityId: number, city: City): Observable<Object>{
    return this.httpClient.put(this.baseURL+"updateCity/"+`${cityId}`,city);
  }
  deleteCity(cityId: number):Observable<object> {
    return this.httpClient.put(this.baseURL+"deleteCity/"+`${cityId}`,null);
  }
  
}
