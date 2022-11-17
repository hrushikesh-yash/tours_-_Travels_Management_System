import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs';
import { VehicleDriverMapping } from 'src/app/modules/VehicleDriverMapping';
import { MappingVehicleDriverService } from 'src/app/Services/mapping-vehicle-driver.service';

@Component({
  selector: 'app-vehicle-driver-mapping-list',
  templateUrl: './vehicle-driver-mapping-list.component.html',
  styleUrls: ['./vehicle-driver-mapping-list.component.scss']
})
export class VehicleDriverMappingListComponent implements OnInit {

  vehicleDriverMappings:VehicleDriverMapping[];

  isDeleting:boolean=false;
  constructor(private mappingVehicleDriverService: MappingVehicleDriverService) { }

  ngOnInit(): void {
     this.isDeleting = false;

     this.mappingVehicleDriverService.findAllMappingVehicleDriver()
     .pipe(first())
     .subscribe({
      next:(data)=>{
        this.vehicleDriverMappings=data;
        console.log(this.vehicleDriverMappings);
      },
      error:(error) => console.log(error)
     });

  }
  deleteState(mappingVehicleDriverDetailsId: number) {

    this.isDeleting = true;
    this.mappingVehicleDriverService.deleteMappingVehicleDriver(mappingVehicleDriverDetailsId)
      .pipe(first())
      .subscribe(() => this.vehicleDriverMappings = this.vehicleDriverMappings.filter(x => x.mappingVehicleDriverDetailsId !== mappingVehicleDriverDetailsId));
      this.isDeleting = false;
      this.isDeleting = false;
  }

}
