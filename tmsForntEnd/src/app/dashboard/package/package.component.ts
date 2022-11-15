import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs';
import { BookingHistory } from 'src/app/modules/BookingHistory';
import { User } from 'src/app/modules/masterUser';
import { BookingHistoryService } from 'src/app/Services/booking-history.service';

@Component({
  selector: 'app-package',
  templateUrl: './package.component.html',
  styleUrls: ['./package.component.css']
})
export class PackageComponent implements OnInit {

   cartItems:number=1;
   totalAmmount:number =10;
  bookingHistoryItems:BookingHistory[];
  currentUser:User;

  constructor(private bookingService:BookingHistoryService) { }

  ngOnInit(): void {

    let user = JSON.parse(localStorage.getItem("user") as any);//localStorage.getItem('user');
    this.currentUser = user;
    this.bookingService.getBookingByUserId(this.currentUser.userId)
    .pipe(first())
    .subscribe({
      next: (data) => {
        this.bookingHistoryItems = data;
        console.log(this.bookingHistoryItems);
        this.cartItems=this.bookingHistoryItems.length;
      },
      error: (error) => console.log(error)
    });


  }

}
