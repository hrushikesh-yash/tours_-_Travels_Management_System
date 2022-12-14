import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { map } from 'rxjs/operators';
import {User} from '../modules/masterUser';
 export interface user {
  username: string;
  password: string;
 }

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
 loggedInUser:User;
   baseURL:String = "http://localhost:8080/user/";

  sharedUserId!:number;
  user: user;

  constructor(private httpClient: HttpClient) { }
  
  getUserList(): Observable<User[]>{
    return this.httpClient.get<User[]>(this.baseURL+"getAllUsers"); 
  }

  getAllByActorId(actorId:number): Observable<User[]>{
    return this.httpClient.get<User[]>(this.baseURL+"getAllByActorId/"+`${actorId}`); 
  }

  createUser(user: User): Observable<User>{
    return this.httpClient.post<User>(this.baseURL+"addUser", user);
  }

  findUserById(id: number): Observable<User>{
    
    return this.httpClient.get<User>(this.baseURL+"findUserById/"+`${id}`);
    
  }

  updateUser(id: number, user: User): Observable<Object>{
    return this.httpClient.put(this.baseURL+"updateUser/"+`${id}`,user);
  }

  deleteUser(id: number):Observable<any>
  {
    console.log("delete user id: " + id );
    return this.httpClient.get(this.baseURL+"delete/"+`${id}`);
  }
  
  sharedDate(userId:number) 
  {
    this.sharedUserId=userId;
  }

  getUserId()
  {
    return this.sharedUserId;
  }

  login(userName:string, password:string): Observable<User> {
    return this.httpClient.get<User>(this.baseURL+"getUserCredentials",{params:{userName,password}});
  }

  getLoginUser() 
  {
    return this.loggedInUser;
  }

  shareLoginUser(user:User) 
  {
     this.loggedInUser=user;
  }
}
