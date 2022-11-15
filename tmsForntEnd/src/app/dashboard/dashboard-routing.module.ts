import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard.component';
import { PackageComponent } from './package/package.component';
const stateModule = () => import('./state/state.module').then(x => x.StateModule);
const cityModule = () => import('./city/city.module').then(x => x.CityModule);
const tourModule = () => import('./master-tour/tour.module').then(x => x.TourModule);
const vehicleTypeModule = () => import('./vehicle-type/vehicle-type.module').then(x => x.VehicleTypeModule);
const vehicleModule = () => import('./vehicle/vehicle.module').then(x => x.VehicleModule);
const cityRoutesModule = () => import('./city-routes/city-routes.module').then(x => x.CityRoutesModule);
const vehicleDriverMappingModule = () => import('./vehicle-driver-mapping/vehicle-driver-mapping.module').then(x => x.VehicleDriverMappingModule);


const routes: Routes = [
  {
    path: '', component: DashboardComponent,
    children: [
      { path: 'Package', component: PackageComponent },
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
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
