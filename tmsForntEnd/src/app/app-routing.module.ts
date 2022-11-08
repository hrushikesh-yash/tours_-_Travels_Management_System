import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MasterActorComponent } from './master-actor/master-actor.component';
import { AddUserComponent } from './master-user/add-user/add-user.component';
import { MasterUserComponent } from './master-user/master-user.component';
import { UpdateMasterUserComponent } from './master-user/update-master-user/update-master-user.component';

const stateModule=() => import ('./State/state/state.module').then(x=>x.StateModule);
const cityModule=() => import ('./city/city.module').then(x=>x.CityModule);
const tourModule=() => import ('./master-tour/tour.module').then(x=>x.TourModule);
const vehicleTypeModule=() => import ('./vehicle-type/vehicle-type.module').then(x=>x.VehicleTypeModule);
<<<<<<< HEAD
const vehicleModule=() => import ('./vehicle/vehicle.module').then(x=>x.VehicleModule);
=======
>>>>>>> a883caf69a40871958203f2c8411b457798c627d

const routes: Routes = 
[
  { path :'masterActor',component:MasterActorComponent},
  { path :'masterUser',   component:MasterUserComponent},
  { path :'masterUser/:id',component: UpdateMasterUserComponent},
  { path :'addUser',component: AddUserComponent},

  { path :'State', loadChildren:stateModule},
  { path :'City', loadChildren:cityModule},
<<<<<<< HEAD
  { path :'Tour',loadChildren:tourModule},
  { path :'Vehicle-Type',loadChildren:vehicleTypeModule},
  {path:'Vehicle',loadChildren:vehicleModule}


=======
  { path :'masterTour',loadChildren:tourModule},
  {path :'Vehicle-Type',loadChildren:vehicleTypeModule}
>>>>>>> a883caf69a40871958203f2c8411b457798c627d
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

export const routingComponents = [
  MasterActorComponent,
  // MasterCityComponent,
  MasterUserComponent,
  UpdateMasterUserComponent,
  AddUserComponent
]
