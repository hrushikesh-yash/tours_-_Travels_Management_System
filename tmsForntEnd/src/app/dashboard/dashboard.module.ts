import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { PackageComponent } from './package/package.component';
import { DashboardComponent } from './dashboard.component';
import { BodyComponent } from '../body/body.component';
import { SidenavComponent } from '../sidenav/sidenav.component';
import { BookingReportComponent } from './booking-report/booking-report.component';


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
    DashboardRoutingModule
  ]
})
export class DashboardModule { }
