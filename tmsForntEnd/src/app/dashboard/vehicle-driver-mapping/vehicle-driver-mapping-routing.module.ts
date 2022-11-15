import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEditVehicleDriverMappingComponent } from './add-edit-vehicle-driver-mapping/add-edit-vehicle-driver-mapping.component';
import { VehicleDriverMappingListComponent } from './vehicle-driver-mapping-list/vehicle-driver-mapping-list.component';
import { VehicleDriverMappingComponent } from './vehicle-driver-mapping.component';

const routes: Routes = [
  {path:'',component:VehicleDriverMappingComponent,
  children:[
    {path:'',component:VehicleDriverMappingListComponent},
    {path:'addVehicleDriverAssign',component:AddEditVehicleDriverMappingComponent},
    {path:'editVehicleDriverAssign/:id',component:AddEditVehicleDriverMappingComponent},

  ]
  
}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VehicleDriverMappingRoutingModule { }
