import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MasterStateComponent } from './master-state/master-state.component';
import { AddEditStateComponent } from './add-edit-state/add-edit-state.component';
import { StateListComponent } from './state-list/state-list.component';

const routes: Routes = [
    {
        path: '', component: MasterStateComponent,
        children: [
            { path: '', component: StateListComponent },
            { path: 'add', component: AddEditStateComponent },
            { path: 'edit/:id', component: AddEditStateComponent }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class StateRoutingModule { 
    
}



