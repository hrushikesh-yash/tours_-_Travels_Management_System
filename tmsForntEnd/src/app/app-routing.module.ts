import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MasterActorComponent } from './master-actor/master-actor.component';
import { MasterCityComponent } from './master-city/master-city.component';
import { MasterStateComponent } from './master-state/master-state.component';
import { MasterTourComponent } from './master-tour/master-tour.component';

const routes: Routes = 
[
  { path :'masterActor',component:MasterActorComponent},
  { path :'masterState',component:MasterStateComponent},
  { path : 'masterCity',component:MasterCityComponent},
  { path : 'masterTour',component:MasterTourComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

export const routingComponents = [
  MasterActorComponent,MasterStateComponent,MasterCityComponent
]
