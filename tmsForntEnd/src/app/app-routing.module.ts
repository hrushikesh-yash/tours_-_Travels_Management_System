import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MasterActorComponent } from './master-actor/master-actor.component';
import { MasterCityComponent } from './master-city/master-city.component';
import { MasterTourComponent } from './master-tour/master-tour.component';
import { AddUserComponent } from './master-user/add-user/add-user.component';
import { MasterUserComponent } from './master-user/master-user.component';
import { UpdateMasterUserComponent } from './master-user/update-master-user/update-master-user.component';

const stateModule=() => import ('./master-state/state/state.module').then(x=>x.StateModule);


const routes: Routes = 
[
  { path :'masterActor',component:MasterActorComponent},
  { path :'masterCity',component:MasterCityComponent},
  { path :'masterTour',component:MasterTourComponent},
  { path :'masterUser',   component:MasterUserComponent},
  { path :'masterUser/:id',component: UpdateMasterUserComponent},
  { path :'addUser',component: AddUserComponent},

  { path :'State', loadChildren:stateModule},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

export const routingComponents = [
  MasterActorComponent,
  MasterCityComponent,
  MasterUserComponent,
  UpdateMasterUserComponent,
  AddUserComponent
]
