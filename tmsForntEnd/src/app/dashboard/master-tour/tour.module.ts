import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TourListComponent } from './tour-list/tour-list.component';
import { MasterTourComponent } from './master-tour.component';
import { TourRoutingModule } from './TourRoutingModule';
import {  FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddEditTourComponent } from './add-edit-tour/add-edit-tour.component';



@NgModule({
  imports: [
    CommonModule,
    FormsModule,
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
