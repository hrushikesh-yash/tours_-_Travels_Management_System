import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { MasterActorComponent } from './master-actor/master-actor.component';
import { MasterStateComponent } from './master-state/master-state.component';
import { MasterCityComponent } from './master-city/master-city.component';
import { MasterTourComponent } from './master-tour/master-tour.component';

@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    MasterStateComponent,
    MasterCityComponent,
    MasterTourComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
