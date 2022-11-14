import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MasterActorComponent } from './master-actor/master-actor.component';
import { AddUserComponent } from './master-user/add-user/add-user.component';
import { MasterUserComponent } from './master-user/master-user.component';
import { UpdateMasterUserComponent } from './master-user/update-master-user/update-master-user.component';

const stateModule = () => import('./State/state/state.module').then(x => x.StateModule);
const cityModule = () => import('./city/city.module').then(x => x.CityModule);
const tourModule = () => import('./master-tour/tour.module').then(x => x.TourModule);
const vehicleTypeModule = () => import('./vehicle-type/vehicle-type.module').then(x => x.VehicleTypeModule);
const vehicleModule = () => import('./vehicle/vehicle.module').then(x => x.VehicleModule);
const cityRoutesModule = () => import('./city-routes/city-routes.module').then(x => x.CityRoutesModule);
const vehicleDriverMappingModule = () => import('./vehicle-driver-mapping/vehicle-driver-mapping.module').then(x => x.VehicleDriverMappingModule)
const accountModule = () => import('./account/account.module').then(x => x.AccountModule);

const routes: Routes =
  [
    { path: '', loadChildren: accountModule },
    {
      path: 'Dashboard', component: DashboardComponent,
      children: [
        { path: 'State', loadChildren: stateModule },
        { path: 'City', loadChildren: cityModule },
        { path: 'Tour', loadChildren: tourModule },
        { path: 'Vehicle-Type', loadChildren: vehicleTypeModule },
        { path: 'Vehicle', loadChildren: vehicleModule },
        { path: 'City-Routes', loadChildren: cityRoutesModule },
        { path: 'Vehicle-Driver-Assign', loadChildren: vehicleDriverMappingModule }
      ]
    },


  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

export const routingComponents = [
  MasterActorComponent,
  MasterUserComponent,
  UpdateMasterUserComponent,
  AddUserComponent
]
