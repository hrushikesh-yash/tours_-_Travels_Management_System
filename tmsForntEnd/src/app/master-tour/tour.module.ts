import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TourListComponent } from './tour-list/tour-list.component';
import { MasterTourComponent } from './master-tour.component';
import { TourRoutingModule } from './TourRoutingModule';
<<<<<<< HEAD
=======
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
>>>>>>> a883caf69a40871958203f2c8411b457798c627d
import { AddEditTourComponent } from './add-edit-tour/add-edit-tour.component';



@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
<<<<<<< HEAD
    // FormsModule,
=======
>>>>>>> a883caf69a40871958203f2c8411b457798c627d
    TourRoutingModule
  ],
  declarations: [
    MasterTourComponent,
    TourListComponent,
    AddEditTourComponent
  ],
  
})
export class TourModule { }
