import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TourListComponent } from './tour-list/tour-list.component';
import { MasterTourComponent } from './master-tour.component';
import { TourRoutingModule } from './TourRoutingModule';
import {  ReactiveFormsModule } from '@angular/forms';
import { AddEditTourComponent } from './add-edit-tour/add-edit-tour.component';



@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    TourRoutingModule
  ],
  declarations: [
    MasterTourComponent,
    TourListComponent,
    AddEditTourComponent
  ],
  
})
export class TourModule { }
