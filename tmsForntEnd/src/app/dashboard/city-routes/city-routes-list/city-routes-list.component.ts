import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { BookingHistory } from 'src/app/modules/BookingHistory';
import { CityRoutes } from 'src/app/modules/CityRoutes';
import { User } from 'src/app/modules/masterUser';
import { AlertService } from 'src/app/Services/alert-service.service';
import { BookingHistoryService } from 'src/app/Services/booking-history.service';
import { CityRoutesService } from 'src/app/Services/city-routes.service';

@Component({
  selector: 'app-city-routes-list',
  templateUrl: './city-routes-list.component.html',
  styleUrls: ['./city-routes-list.component.css']
})
export class CityRoutesListComponent implements OnInit {

  cityRoutes:CityRoutes[];
  cityRoute:CityRoutes;
  currentUser:User;
  bookingHistory:BookingHistory;

  isDeleting:boolean=false;
  pendingStatus: number=1;
  constructor(private cityRoutesService: CityRoutesService,
      private bookingHistoryService:BookingHistoryService,
      private altertService:AlertService,
              private route: ActivatedRoute, 
              private router: Router) { }

  ngOnInit(): void {
     this.isDeleting = false;
    this.cityRoutesService.findAllRoutes()
      .pipe(first())
      .subscribe({
        next: (data) => {
          this.cityRoutes = data;
          // console.log(data);
        },
        error: (error) => console.log(error)
      });

      let user = JSON.parse(localStorage.getItem("user") as any);//localStorage.getItem('user');
    this.currentUser = user;

  }
  deleteState(routeId: number) {

    this.isDeleting = true;
    this.cityRoutesService.deleteRoute(routeId)
      .pipe(first())
      .subscribe(() => this.cityRoutes = this.cityRoutes.filter(x => x.routeId !== routeId));
      this.isDeleting = false;
      this.isDeleting = false;
  }

  addToTour(cityRouteId:number)
  {
    console.log(cityRouteId)
    this.cityRoutesService.findRouteById(cityRouteId)
    .pipe(first())
    .subscribe({
      next:(data) =>
      {
        this.cityRoute=data
        console.log(this.cityRoute.routeId)

        this.bookingHistoryService.findByStatusId(this.pendingStatus)
        .pipe(first())
        .subscribe({
          next:(data) =>{
            this.bookingHistory=data
            console.log(this.bookingHistory)
            this.bookingHistory.cityRoute=this.cityRoute;
            this.bookingHistory.travelAmount+=this.cityRoute.routePrice
            console.log(this.bookingHistory)

            this.bookingHistoryService.addBooking(this.bookingHistory)
            .pipe(first())
            .subscribe({
              next:(data) =>{
                this.altertService.success('City Route added in your Package Sucessfullly !', { keepAfterRouteChange: true });
                // this.router.navigate(['../Package'], { relativeTo: this.route });

              },
              error :(err) => console.log(err)             
            });
          }
          ,error: (err) => console.log(err)
        });

      }
      ,error:(err)=> console.log(err)
    });

  }

}
