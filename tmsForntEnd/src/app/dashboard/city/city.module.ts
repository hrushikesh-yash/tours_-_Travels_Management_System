import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddEditCityComponent } from './add-edit-city/add-edit-city.component';
import { CityRoutingModule } from './CityRoutingModule';
import { CityListComponent } from './city-list/city-list.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CityComponent } from './city.component';



@NgModule({
  declarations: [
    AddEditCityComponent,
    CityListComponent,CityComponent
  ],
  imports: [
    CommonModule,
    CityRoutingModule,
    ReactiveFormsModule
  ]
})
export class CityModule { }
