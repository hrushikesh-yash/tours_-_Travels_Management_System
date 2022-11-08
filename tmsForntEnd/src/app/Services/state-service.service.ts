import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { State } from '../modules/State';

@Injectable({
  providedIn: 'root'
})
export class StateServiceService {
  
  

  baseURL:String = "http://localhost:8080/state/";

  constructor(private httpClient: HttpClient) { }
  
  getStateList(): Observable<State[]>{
    return this.httpClient.get<State[]>(this.baseURL+"getAllStates"); 
  }

  findStateById(id: number):Observable<State>{
    return this.httpClient.get<State>(this.baseURL+"findStateById/"+`${id}`);
  }

  addState(state: State):Observable<State>{
    return this.httpClient.post<State>(this.baseURL+"addState", state);
  }

  updateState(id: number, state: State): Observable<Object>{
    return this.httpClient.put(this.baseURL+"updateState/"+`${id}`,state);
  }
  
  deleteState(stateId: number):Observable<object> {
    return this.httpClient.put(this.baseURL+"deleteState/"+`${stateId}`,null);
  }
  
}
