import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs';
import { User } from 'src/app/modules/masterUser';
import { Vehicle } from 'src/app/modules/Vehicle';
import { VehicleService } from 'src/app/Services/vehicle.service';

@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.css']
})
export class VehicleListComponent implements OnInit {

  Vehicles?: Vehicle[];
  isDeleting:boolean=false;
  currentUser:User;
  constructor(private vehicleService: VehicleService) { }

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
          this.Vehicles = data;
          // console.log(data);
        },
        error: (error) => console.log(error)
      });
  }

  deleteState(vehicleId: number) {

    this.isDeleting = true;
    this.vehicleService.deleteVehicle(vehicleId)
      .pipe(first())
      .subscribe(() => this.Vehicles = this.Vehicles?.filter(x => x.vehicleId !== vehicleId));
      this.isDeleting = false;
      this.isDeleting = false;
  }
  

}
