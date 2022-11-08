import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vehicle } from '../modules/Vehicle';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  baseURL:String = "http://localhost:8080/vehicleDetails/";

  constructor(private httpClient:HttpClient) { }

  getVehicleTypeList(): Observable<Vehicle[]>{
    return this.httpClient.get<Vehicle[]>(this.baseURL+"getAllVehicleDetails"); 
  }

  findVehicleById(id: number):Observable<Vehicle>{
    return this.httpClient.get<Vehicle>(this.baseURL+"findVehicleById/"+`${id}`);
  }

  addVehicleDetails(vehicle: Vehicle):Observable<Vehicle>{
    return this.httpClient.post<Vehicle>(this.baseURL+"addVehicleDetails", vehicle);
  }

  updateVehicle(id: number, vehicle: Vehicle): Observable<Object>{
    return this.httpClient.put(this.baseURL+"updateVehicleDetails/"+`${id}`,vehicle);
  }

  deleteVehicle(id: number):Observable<object> {
    return this.httpClient.put(this.baseURL+"delete/"+`${id}`,null);
  }
}
