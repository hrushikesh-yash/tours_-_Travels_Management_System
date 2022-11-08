import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddEditTourComponent } from './add-edit-tour/add-edit-tour.component';
import { MasterTourComponent } from './master-tour.component';
import { TourListComponent } from './tour-list/tour-list.component';


const routes: Routes = [
    {
        path: '', component: MasterTourComponent,
        children: [
            { path: '', component: TourListComponent },
            { path: 'add', component: AddEditTourComponent},
            { path: 'edit/:id', component:AddEditTourComponent }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class TourRoutingModule { 
    
}



