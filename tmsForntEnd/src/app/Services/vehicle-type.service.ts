import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { VehicleType } from '../modules/VehicleType';

@Injectable({
  providedIn: 'root'
})
export class VehicleTypeService {

  baseURL:String = "http://localhost:8080/vehicletype/";

  constructor(private httpClient: HttpClient) { }
  
  getVehicleTypeList(): Observable<VehicleType[]>{
    return this.httpClient.get<VehicleType[]>(this.baseURL+"getAllvehicletypes"); 
  }

  findVehicleTypeById(id: number):Observable<VehicleType>{
    return this.httpClient.get<VehicleType>(this.baseURL+"findVehicleTypeById/"+`${id}`);
  }

  addVehicleType(vehicleType: VehicleType):Observable<VehicleType>{
    return this.httpClient.post<VehicleType>(this.baseURL+"addVehicleType", vehicleType);
  }

  updateVehicleType(id: number, vehicleType: VehicleType): Observable<Object>{
    return this.httpClient.put(this.baseURL+"updateVehicleType/"+`${id}`,vehicleType);
  }

  deleteVehicleType(id: number):Observable<object> {
    return this.httpClient.put(this.baseURL+"delete/"+`${id}`,null);
  }
}
