import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BookingHistory } from '../modules/BookingHistory';

@Injectable({
  providedIn: 'root'
})
export class BookingHistoryService {
 
 
  baseURL:String = "http://localhost:8080/bookingHistory/"

  constructor(private httpClient: HttpClient) { }

  addBooking(bookingHistory: BookingHistory):Observable<BookingHistory>{
    return this.httpClient.post<BookingHistory>(this.baseURL+"addBookingHistory",bookingHistory);
  }

  getBookingByUserId(userId:number):Observable<BookingHistory[]>{
    return this.httpClient.get<BookingHistory[]>(this.baseURL+"findBookingByUserId/"+`${userId}`);
  }

  findByStatusId(pendingStatus: number):Observable<BookingHistory> {
    return this.httpClient.get<BookingHistory>(this.baseURL+"findByStatusId/"+`${pendingStatus}`)
  }

  getAllAbookings():Observable<BookingHistory[]> 
  {
    return this.httpClient.get<BookingHistory[]>(this.baseURL+"findAllBookingHistory");
  }



}
