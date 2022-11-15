import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { BookingHistory } from 'src/app/modules/BookingHistory';
import { User } from 'src/app/modules/masterUser';
import { Tour } from 'src/app/modules/Tour';
import { AlertService } from 'src/app/Services/alert-service.service';
import { BookingHistoryService } from 'src/app/Services/booking-history.service';
import { TourService } from 'src/app/Services/tour.service';

@Component({
  selector: 'app-tour-list',
  templateUrl: './tour-list.component.html',
  styleUrls: ['./tour-list.component.css']
})
export class TourListComponent implements OnInit {

  tours?:Tour[];
  currentUser:User;
  booking:BookingHistory= new BookingHistory;

  submitted = false;

  userImage: String ="https://sm.mashable.com/t/mashable_in/article/1/11-best-ap/11-best-apps-for-going-on-a-road-trip_xsw8.1248.jpg";

  constructor(private route: ActivatedRoute, 
    private router: Router,
    private http:HttpClient,
    private formBuilder: FormBuilder,
    private tourService:TourService,
    private alertService:AlertService,
    private bookingService:BookingHistoryService) { }

  ngOnInit(): void {
    this.getTourList()

    let user = JSON.parse(localStorage.getItem("user") as any);//localStorage.getItem('user');
    this.currentUser = user;
    console.log(this.currentUser.firstName);
  }

  getTourList()
  {
    this.tourService.getTourList()
    .subscribe({
      next: (data) => {
        this.tours = data;
        console.log(this.tours);
      },
      error: (e) => console.error(e)
    });
  }

  updateTour(tourId: number)
  {
    console.log(tourId);
    // this.userService.sharedDate(userId);
    // this.router.navigate([userId], { relativeTo: this.route });
  }

  deleteTour(tourId: number)
  {
    console.log(tourId);
    this.tourService.deleteTour(tourId)
    .subscribe({
      next: (data) => {
        
         console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  addToTour(tourId:number)
  {
    
    this.booking.tourId=tourId;
    this.booking.userId=this.currentUser.userId;
    console.log("User Id:: "+this.booking.userId);
    // this.bookingService.addBooking(this.booking)
    // .pipe(first())
    // .subscribe({
    //   next: () => {
    //     this.alertService.info('Tour added in Package Sucessfullly !', { keepAfterRouteChange: true });
    //     this.router.navigate(['../'], { relativeTo: this.route });
    //   },
    //   error: error => {
    //     this.alertService.error(error);
    //   }
    // });
  }

}
