import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VehicleTypeRoutingModule } from './vehicle-type-routing.module';
import { AddEditVehicleTypeComponent } from './add-edit-vehicle-type/add-edit-vehicle-type.component';
import { VehicleTypeListComponent } from './vehicle-type-list/vehicle-type-list.component';
import { VehicleTypeComponent } from './vehicle-type.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AddEditVehicleTypeComponent,
    VehicleTypeListComponent,
    VehicleTypeComponent
  ],
  imports: [
    CommonModule,
    VehicleTypeRoutingModule,
    ReactiveFormsModule
  ]

})
export class VehicleTypeModule { }
