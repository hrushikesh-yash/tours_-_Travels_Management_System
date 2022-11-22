import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Actor } from '../modules/Actor';

@Injectable({
  providedIn: 'root'
})
export class ActorService {
  baseURL: String = "http://localhost:8080/actor/";

  constructor(private httpClient:HttpClient) { }

  findActorById(actorId:number): Observable<Actor> {
    return this.httpClient.get<Actor>(this.baseURL+"findActorByActorId/"+`${actorId}`);
  }
}
