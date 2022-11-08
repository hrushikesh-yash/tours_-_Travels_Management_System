import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VehicleRoutingModule } from './vehicle-routing.module';
import { VehicleComponent } from '../vehicle/vehicle.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { AddEditVehicleComponent } from './add-edit-vehicle/add-edit-vehicle.component';


@NgModule({
  declarations: [
    VehicleComponent,
    VehicleListComponent,
    AddEditVehicleComponent
  ],
  imports: [
    CommonModule,
    VehicleRoutingModule
  ]
})
export class VehicleModule { }
