import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VehicleTypeListComponent } from './vehicle-type-list/vehicle-type-list.component';
import { AddEditVehicleTypeComponent } from './add-edit-vehicle-type/add-edit-vehicle-type.component';
import { VehicleTypeRoutingModule } from './VehicleTypeRouting';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    VehicleTypeRoutingModule
  ],
  declarations: [
    VehicleTypeListComponent,
    AddEditVehicleTypeComponent
  ]
  
})
export class VehicleTypeModule { }
