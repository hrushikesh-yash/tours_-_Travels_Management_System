import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { VehicleDriverMapping } from '../modules/VehicleDriverMapping';

@Injectable({
  providedIn: 'root'
})
export class MappingVehicleDriverService {


  baseURL:String = "http://localhost:8080/mappingVehicleDriver/";

  constructor(private httpClient:HttpClient) { }

  findAllMappingVehicleDriver(): Observable<VehicleDriverMapping[]>{
    return this.httpClient.get<VehicleDriverMapping[]>(this.baseURL+"findAllMappingVehicleDriver"); 
  }

  findMappingVehicleDriverById(id: number):Observable<VehicleDriverMapping>{
    return this.httpClient.get<VehicleDriverMapping>(this.baseURL+"findMappingVehicleDriverById/"+`${id}`);
  }

  addMappingVehicleDriver(vehicleDriverMapping: VehicleDriverMapping):Observable<VehicleDriverMapping>{
    return this.httpClient.post<VehicleDriverMapping>(this.baseURL+"addMappingVehicleDriver", vehicleDriverMapping);
  }

  updateMappingVehicleDriver(id: number, vehicleDriverMapping: VehicleDriverMapping): Observable<Object>{
    return this.httpClient.put(this.baseURL+"updateMappingVehicleDriver/"+`${id}`,vehicleDriverMapping);
  }

  deleteMappingVehicleDriver(id: number):Observable<object> {
    return this.httpClient.put(this.baseURL+"deleteMappingVehicleDriver/"+`${id}`,null);
  }
}
