import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs';
import { User } from 'src/app/modules/masterUser';
import { VehicleType } from 'src/app/modules/VehicleType';
import { VehicleTypeService } from 'src/app/Services/vehicle-type.service';


@Component({
  selector: 'app-vehicle-type-list',
  templateUrl: './vehicle-type-list.component.html',
  styleUrls: ['./vehicle-type-list.component.scss']
})
export class VehicleTypeListComponent implements OnInit {


  vehicletypes: VehicleType[];
  isDeleting: boolean = false;
  currentUser:User;
  constructor(private vehicleTypeService: VehicleTypeService,
    private datePipe: DatePipe) { }

  ngOnInit(): void {
    this.getVehicleTypeList();

    let user = JSON.parse(localStorage.getItem("user") as any);//localStorage.getItem('user');
    this.currentUser = user;
  }

  getVehicleTypeList() {
    this.vehicleTypeService.getVehicleTypeList()
      .pipe(first())
      .subscribe({
        next: (data) => {
          this.vehicletypes = data;
          console.log(this.vehicletypes);
        },
        error: (error) => console.log(error)
      })
  }

  deleteVehicleType(vehicletypeId: number) {
    console.log(vehicletypeId);
    this.vehicleTypeService.deleteVehicleType(vehicletypeId)
      .pipe(first())
      .subscribe(() => this.vehicletypes = this.vehicletypes?.filter(x => x.vehicleTypeId !== vehicletypeId));
    this.isDeleting = false;
  }
}
