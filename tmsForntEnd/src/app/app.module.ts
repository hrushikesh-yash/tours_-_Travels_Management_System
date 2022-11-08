import { DatePipe } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AlertComponent } from './alter/alert.component';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
<<<<<<< HEAD
import { VehicleModule } from './Services/vehicle/vehicle.module';

=======
>>>>>>> a883caf69a40871958203f2c8411b457798c627d


@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    AlertComponent,
<<<<<<< HEAD
=======
    
>>>>>>> a883caf69a40871958203f2c8411b457798c627d
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
