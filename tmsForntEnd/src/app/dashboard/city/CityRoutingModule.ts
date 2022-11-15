import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddEditCityComponent } from './add-edit-city/add-edit-city.component';
import { CityListComponent } from './city-list/city-list.component';
import { CityComponent } from './city.component';


const routes: Routes = [
    {
        path: '', component: CityComponent,
        children: [
            { path: '', component: CityListComponent },
            { path: 'add', component: AddEditCityComponent },
            { path: 'edit/:id', component: AddEditCityComponent }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class CityRoutingModule { 
    
}



