import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs';
import { BookingHistory } from 'src/app/modules/BookingHistory';
import { BookingHistoryService } from 'src/app/Services/booking-history.service';

@Component({
  selector: 'app-booking-report',
  templateUrl: './booking-report.component.html',
  styleUrls: ['./booking-report.component.scss']
})
export class BookingReportComponent implements OnInit {

  bookingHistory:BookingHistory[];
  constructor(
    private bookingHistoryService:BookingHistoryService,
  ) { }

  ngOnInit(): void {
    this.bookingHistoryService.getAllAbookings()
    .pipe(first())
    .subscribe({
      next:(data) =>{
        this.bookingHistory=data
      },
      error :(err) =>
      console.log(err)
      
    });
  }

}
