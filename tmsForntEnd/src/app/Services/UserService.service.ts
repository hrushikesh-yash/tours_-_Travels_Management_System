import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import {User} from '../modules/masterUser';

@Injectable({
  providedIn: 'root'
})
export class UserService {
   baseURL:String = "http://localhost:8080/user";

  sharedUserId!:number;

  constructor(private httpClient: HttpClient) { }
  
  getUserList(): Observable<User[]>{
    return this.httpClient.get<User[]>(this.baseURL+"/getAllUsers"); 
  }

  // createEmployee(employee: Employee): Observable<Object>{
  //   return this.httpClient.post(`${this.baseURL}`, employee);
  // }

  findUserById(id: number): Observable<User>{
    console.log("number in the service : "+id )
    return this.httpClient.get<User>(this.baseURL+"/findUserById/"+{id});
    
  }

  // updateEmployee(id: number, employee: Employee): Observable<Object>{
  //   return this.httpClient.put(`${this.baseURL}/${id}`, employee);
  // }

  // deleteEmployee(id: number): Observable<Object>{
  //   return this.httpClient.delete(`${this.baseURL}/${id}`);
  // }
  
  sharedDate(userId:number) 
  {
    this.sharedUserId=userId;
  }

  getUserId()
  {
    return this.sharedUserId;
  }
}
