import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CityRoutesRoutingModule } from './city-routes-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { CityRoutesComponent } from './city-routes.component';
import { AddEditCityRoutesComponent } from './add-edit-city-routes/add-edit-city-routes.component';
import { CityRoutesListComponent } from './city-routes-list/city-routes-list.component';


@NgModule({
  declarations: [
    CityRoutesComponent,
    AddEditCityRoutesComponent,
    CityRoutesListComponent

  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    CityRoutesRoutingModule
  ]
})
export class CityRoutesModule { }
