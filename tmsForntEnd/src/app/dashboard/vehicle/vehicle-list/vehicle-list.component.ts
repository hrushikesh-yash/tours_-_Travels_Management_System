import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { BookingHistory } from 'src/app/modules/BookingHistory';
import { User } from 'src/app/modules/masterUser';
import { Vehicle } from 'src/app/modules/Vehicle';
import { AlertService } from 'src/app/Services/alert-service.service';
import { BookingHistoryService } from 'src/app/Services/booking-history.service';
import { VehicleService } from 'src/app/Services/vehicle.service';

@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.css']
})
export class VehicleListComponent implements OnInit {

  vehicles: Vehicle[];
  vehicle:Vehicle;
  isDeleting:boolean=false;
  currentUser:User;
  pendingStatus:number=1;
  bookingHistory:BookingHistory;

  constructor(private vehicleService: VehicleService,
              private bookingService:BookingHistoryService,
              private altertService:AlertService,
              private route: ActivatedRoute, 
              private router: Router) { }

  ngOnInit(): void {
     this.isDeleting = false;
    
     this.getVehicleList();
     let user = JSON.parse(localStorage.getItem("user") as any);//localStorage.getItem('user');
     this.currentUser = user; 
    
  }

  getVehicleList()
  {
    this.vehicleService.getVehicleTypeList()
      .pipe(first())
      .subscribe({
        next: (data) => {
          this.vehicles = data;
         // console.log(this.vehicles);
        },
        error: (error) => console.log(error)
      });
  }

  deleteState(vehicleId: number) {

    this.isDeleting = true;
    this.vehicleService.deleteVehicle(vehicleId)
      .pipe(first())
      .subscribe(() => this.vehicles = this.vehicles?.filter(x => x.vehicleId !== vehicleId));
      this.isDeleting = false;
      this.isDeleting = false;
  }

  addToTour(vehicleId:number)
  {
    this.vehicleService.findVehicleById(vehicleId)
    .pipe(first())
    .subscribe({
      next:(data) =>
      {
        this.vehicle=data

        this.bookingService.findByStatusId(this.pendingStatus)
        .pipe(first())
        .subscribe({
          next:(data) =>{
            this.bookingHistory=data;
            this.bookingHistory.vehicle=this.vehicle;
            console.log(this.bookingHistory) 

            this.bookingService.addBooking(this.bookingHistory)
            .pipe(first())
            .subscribe({
              next: () => {
                this.altertService.success('Vehicle added in your Package Sucessfullly !', { keepAfterRouteChange: true });
                this.router.navigate(['../City-Routes'], { relativeTo: this.route });
              },
              error: error => {
                this.altertService.error(error);
              }
            });


          },
          error :(err: any) => console.log(err)
        });


      },
      error :(err) =>{
        console.log(err);
      }
    });
  }
  

}
