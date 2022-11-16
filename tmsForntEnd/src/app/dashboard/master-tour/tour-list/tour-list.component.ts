import { DatePipe, formatDate } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { BookingHistory } from 'src/app/modules/BookingHistory';
import { User } from 'src/app/modules/masterUser';
import { Status } from 'src/app/modules/Status';
import { Tour } from 'src/app/modules/Tour';
import { AlertService } from 'src/app/Services/alert-service.service';
import { BookingHistoryService } from 'src/app/Services/booking-history.service';
import { StatusService } from 'src/app/Services/status.service';
import { TourService } from 'src/app/Services/tour.service';

@Component({
  selector: 'app-tour-list',
  templateUrl: './tour-list.component.html',
  styleUrls: ['./tour-list.component.css']
})
export class TourListComponent implements OnInit {

  tours: Tour[];
  tour: Tour;
  status: Status;
  currentUser: User;
  booking: BookingHistory = new BookingHistory;
  travellingStartDate: Date;
  travellingEndDate: Date;

  submitted = false;

  userImage: String = "https://sm.mashable.com/t/mashable_in/article/1/11-best-ap/11-best-apps-for-going-on-a-road-trip_xsw8.1248.jpg";

  constructor(private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient,
    private formBuilder: FormBuilder,
    private tourService: TourService,
    private alertService: AlertService,
    private bookingService: BookingHistoryService,
    private datePipe: DatePipe,
    private statusService: StatusService) { }

  ngOnInit(): void {
    this.getTourList()

    let user = JSON.parse(localStorage.getItem("user") as any);//localStorage.getItem('user');
    this.currentUser = user;

  }

  getTourList() {
    this.tourService.getTourList()
      .subscribe({
        next: (data) => {
          this.tours = data;
          // console.log(this.tours);
        },
        error: (e) => console.error(e)
      });
  }

  updateTour(tourId: number) {
    console.log(tourId);
    // this.userService.sharedDate(userId);
    // this.router.navigate([userId], { relativeTo: this.route });
  }

  deleteTour(tourId: number) {

    console.log(tourId);
    this.tourService.deleteTour(tourId)
      .subscribe({
        next: (data) => {

          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  addToTour(tourId: number) {

    // console.log(this.travellingStartDate,this.travellingEndDate);
    this.tourService.findTourById(tourId)
      .pipe(first())
      .subscribe({
        next: (data) => {
          this.tour = data;
          // console.log(this.tour)
          this.booking.tour = this.tour;
          
          this.booking.travelStartDate=this.travellingStartDate;
          this.booking.travelEndDate=this.travellingEndDate
          this.booking.user = this.currentUser;
          this.statusService.findStatusByName("Pending")
            .pipe(first())
            .subscribe({
              next: (data) => {

                this.status = data;
                this.booking.status = this.status
                this.bookingService.addBooking(this.booking)
                  .pipe(first())
                  .subscribe({
                    next: () => {
                      this.alertService.success('Tour added in your Package Sucessfullly !', { keepAfterRouteChange: true });
                      this.router.navigate(['../Vehicle'], { relativeTo: this.route });
                    },
                    error: error => {
                      this.alertService.error(error);
                    }
                  });

              },
              error: (err) => console.log(err)
            });
          // this.booking.bookingDate=new Date(formatDate(new Date(), 'yyyy/MM/dd','en'));
          // this.booking.travelStartDate=new Date(formatDate(new Date(), 'yyyy/MM/dd','en'));
          // this.booking.travelEndDate=new Date(formatDate(new Date(), 'yyyy/MM/dd','en'));

          console.log(this.booking);
        },
        error: (error) => console.log(error)
      });



  }

}
