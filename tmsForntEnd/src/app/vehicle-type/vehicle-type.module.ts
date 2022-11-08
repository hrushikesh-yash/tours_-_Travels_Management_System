import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
<<<<<<< HEAD

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
=======
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
  
>>>>>>> a883caf69a40871958203f2c8411b457798c627d
})
export class VehicleTypeModule { }
