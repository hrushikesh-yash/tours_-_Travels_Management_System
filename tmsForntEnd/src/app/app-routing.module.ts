import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MasterActorComponent } from './master-actor/master-actor.component';
import { AddUserComponent } from './master-user/add-user/add-user.component';
import { MasterUserComponent } from './master-user/master-user.component';
import { UpdateMasterUserComponent } from './master-user/update-master-user/update-master-user.component';

const accountModule = () => import('./account/account.module').then(x => x.AccountModule);
const dashboardModule = () => import('./dashboard/dashboard.module').then(x => x.DashboardModule);

const routes: Routes =
  [
    { path: '', loadChildren: accountModule },
    {path: 'Dashboard', loadChildren: dashboardModule },


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
