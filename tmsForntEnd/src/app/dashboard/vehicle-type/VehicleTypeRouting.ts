import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddEditVehicleTypeComponent } from './add-edit-vehicle-type/add-edit-vehicle-type.component';
import { VehicleTypeListComponent } from './vehicle-type-list/vehicle-type-list.component';
import { VehicleTypeComponent } from './vehicle-type.component';



const routes: Routes = [
    {
        path: '', component: VehicleTypeComponent,
        children: [
            { path: '', component:  VehicleTypeListComponent},
            // { path: 'add', component: AddEditVehicleTypeComponent },
            // { path: 'edit/:id', component: AddEditVehicleTypeComponent }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class VehicleTypeRoutingModule { }