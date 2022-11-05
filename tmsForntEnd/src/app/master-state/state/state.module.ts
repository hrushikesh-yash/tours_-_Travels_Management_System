import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StateListComponent } from './state-list/state-list.component';
import { MasterStateComponent } from './master-state/master-state.component';
import { StateRoutingModule } from './StateRoutingModule';
import { ReactiveFormsModule } from '@angular/forms';
import { AddEditStateComponent } from './add-edit-state/add-edit-state.component';

@NgModule({
  imports: [
    CommonModule,
    StateRoutingModule,
    ReactiveFormsModule,
  ],
  declarations: [
    StateListComponent,
    MasterStateComponent,
    AddEditStateComponent,
  ],
  
})
export class StateModule { }
