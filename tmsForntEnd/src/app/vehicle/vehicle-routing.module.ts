import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEditVehicleComponent } from './add-edit-vehicle/add-edit-vehicle.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { VehicleComponent } from './vehicle.component';

const routes: Routes = [
  {path:'',component:VehicleComponent,
  children:[
    {path:'',component:VehicleListComponent},
    {path:'add',component:AddEditVehicleComponent},
    {path:'edit/:id',component:AddEditVehicleComponent}

  ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VehicleRoutingModule { }
