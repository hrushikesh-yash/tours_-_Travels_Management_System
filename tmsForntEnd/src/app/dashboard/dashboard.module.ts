import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { PackageComponent } from './package/package.component';
import { DashboardComponent } from './dashboard.component';
import { BodyComponent } from '../body/body.component';
import { SidenavComponent } from '../sidenav/sidenav.component';
import { BookingReportComponent } from './booking-report/booking-report.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    PackageComponent,
    DashboardComponent,
    BodyComponent,
    SidenavComponent,
    BookingReportComponent

  ],
  imports: [
    CommonModule,
    FormsModule,
    DashboardRoutingModule,
    Ng2SearchPipeModule
  ]
})
export class DashboardModule { }
