import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VehicleDriverMappingRoutingModule } from './vehicle-driver-mapping-routing.module';
import { VehicleDriverMappingComponent } from './vehicle-driver-mapping.component';
import { VehicleDriverMappingListComponent } from './vehicle-driver-mapping-list/vehicle-driver-mapping-list.component';
import { AddEditVehicleDriverMappingComponent } from './add-edit-vehicle-driver-mapping/add-edit-vehicle-driver-mapping.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    VehicleDriverMappingComponent,
    VehicleDriverMappingListComponent,
    AddEditVehicleDriverMappingComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    VehicleDriverMappingRoutingModule
  ]
})
export class VehicleDriverMappingModule { }
