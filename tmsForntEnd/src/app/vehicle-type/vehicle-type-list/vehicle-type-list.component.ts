<<<<<<< HEAD
import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs';
import { VehicleType } from 'src/app/modules/VehicleType';
import { VehicleTypeService } from 'src/app/Services/vehicle-type.service';
=======
import { Component, OnInit } from '@angular/core';
>>>>>>> a883caf69a40871958203f2c8411b457798c627d

@Component({
  selector: 'app-vehicle-type-list',
  templateUrl: './vehicle-type-list.component.html',
  styleUrls: ['./vehicle-type-list.component.css']
})
export class VehicleTypeListComponent implements OnInit {

<<<<<<< HEAD
  vehicletypes: VehicleType[];
  isDeleting: boolean = false;
  constructor(private vehicleTypeService: VehicleTypeService,
    private datePipe:DatePipe) { }

  ngOnInit(): void {
    this.getVehicleTypeList()
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

  deleteVehicleType(vehicletypeId:number)
  {
    console.log(vehicletypeId);
    this.vehicleTypeService.deleteVehicleType(vehicletypeId)
      .pipe(first())
      .subscribe(() => this.vehicletypes = this.vehicletypes?.filter(x => x.vehicleTypeId !== vehicletypeId));
      this.isDeleting = false;

=======
  constructor() { }

  ngOnInit(): void {
>>>>>>> a883caf69a40871958203f2c8411b457798c627d
  }

}
