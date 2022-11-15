import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEditCityRoutesComponent } from './add-edit-city-routes/add-edit-city-routes.component';
import { CityRoutesListComponent } from './city-routes-list/city-routes-list.component';
import { CityRoutesComponent } from './city-routes.component';

const routes: Routes = [

  {
    path: '', component: CityRoutesComponent,
    children: [
      { path: '',component: CityRoutesListComponent},
      {path: 'addCity',component: AddEditCityRoutesComponent},
      {path: 'edit/:id',component: AddEditCityRoutesComponent}
  ]

}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CityRoutesRoutingModule { }
