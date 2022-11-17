import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { City } from 'src/app/modules/City';
import { CityRoutes } from 'src/app/modules/CityRoutes';
import { User } from 'src/app/modules/masterUser';
import { Vehicle } from 'src/app/modules/Vehicle';
import { VehicleDriverMapping } from 'src/app/modules/VehicleDriverMapping';
import { AlertService } from 'src/app/Services/alert-service.service';
import { CityRoutesService } from 'src/app/Services/city-routes.service';
import { CityServiceService } from 'src/app/Services/city-service.service';
import { MappingVehicleDriverService } from 'src/app/Services/mapping-vehicle-driver.service';
import { UserService } from 'src/app/Services/UserService.service';
import { VehicleService } from 'src/app/Services/vehicle.service';

@Component({
  selector: 'app-add-edit-vehicle-driver-mapping',
  templateUrl: './add-edit-vehicle-driver-mapping.component.html',
  styleUrls: ['./add-edit-vehicle-driver-mapping.component.scss']
})
export class AddEditVehicleDriverMappingComponent implements OnInit {


  loading = false;
  isAddMode!: boolean;
  id!: number;
  vehicleDriverMappingForm: FormGroup;
  submitted = false;

  cityRoutes: CityRoutes[];
  vehicles: Vehicle[];
  drivers: User[];
  vehicleDriverMapping: VehicleDriverMapping = new VehicleDriverMapping;
  driverActorId: number = 2;
  vehicle: Vehicle;
  cityRoute: CityRoutes;
  user: User;

  mappingVehicleDriverDetailsId: number = 0;

  constructor(private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private cityRoutesService: CityRoutesService,
    private alertService: AlertService,
    private mappingVehicleDriverService: MappingVehicleDriverService,
    private vehicleService: VehicleService,
    private userService: UserService) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];
    console.log("this id :: " + this.id)
    this.isAddMode = !this.id;



    this.getAllVehicles()

    this.getAllCityRoutes()

    this.getAllDrivers()



    this.vehicleDriverMappingForm = this.formBuilder.group({
      mappingVehicleDriverDetailsId: [this.id],
      vehicleId: [''],
      driverId: [''],
      routeId: [''],
      vehicleDriverAssignDate: [''],
      vehicleFare: ['']
    });

    if (!this.isAddMode) {
      this.mappingVehicleDriverService.findMappingVehicleDriverById(this.id)
        .pipe(first())
        .subscribe(x => this.vehicleDriverMappingForm.patchValue(x));
    }


  }



  getAllVehicles() {
    this.vehicleService.getVehicleTypeList()
      .pipe(first())
      .subscribe({
        next: (data: Vehicle[]) => {
          this.vehicles = data;
          console.log(this.vehicles);
        },
        error: (error) => console.log(error)
      });
  }

  getAllCityRoutes() {
    this.cityRoutesService.findAllRoutes()
      .pipe(first())
      .subscribe({
        next: (data: CityRoutes[]) => {
          this.cityRoutes = data;
          console.log(this.vehicles);
        },
        error: (error) => console.log(error)
      });
  }

  getAllDrivers() {

    this.userService.getAllByActorId(this.driverActorId)
      .pipe(first())
      .subscribe({
        next: (data: User[]) => {
          this.drivers = data;
          console.log(this.drivers);
        },
        error: (error) => console.log(error)
      });
  }




  onSubmit() {
    this.submitted = true;
    this.loading = true;
    this.vehicleDriverMapping.mappingVehicleDriverDetailsId = this.id;
    // this.vehicleDriverMapping.vehicleId= this.vehicleDriverMappingForm.controls['vehicleId'].value;
    // this.vehicleDriverMapping.driverId= this.vehicleDriverMappingForm.controls['driverId'].value;
    // this.vehicleDriverMapping.routeId = this.vehicleDriverMappingForm.controls['routeId'].value;
    this.vehicleDriverMapping.vehicleDriverAssignDate = this.vehicleDriverMappingForm.controls['vehicleDriverAssignDate'].value;
    this.vehicleDriverMapping.vehicleFare = this.vehicleDriverMappingForm.controls['vehicleFare'].value;

    this.vehicleService.findVehicleById(this.vehicleDriverMappingForm.controls['vehicleId'].value)
      .pipe(first())
      .subscribe({
        next: (data) => {
          this.vehicle = data;
          this.vehicleDriverMapping.vehicle = this.vehicle;
          this.cityRoutesService.findRouteById(this.vehicleDriverMappingForm.controls['routeId'].value)
            .pipe(first())
            .subscribe({
              next: (data) => {
                this.cityRoute = data
                this.vehicleDriverMapping.route = this.cityRoute;
                this.userService.findUserById(this.vehicleDriverMappingForm.controls['driverId'].value)
                  .pipe(first())
                  .subscribe({
                    next: (data) => {
                      this.user = data
                      this.vehicleDriverMapping.driver = this.user;

                       console.log(this.vehicleDriverMapping);
                      if (this.isAddMode) {
                        console.log(" Add Vehicle Driver Mapping ");


                        this.mappingVehicleDriverService.addMappingVehicleDriver(this.vehicleDriverMapping)
                          .pipe(first())
                          .subscribe({
                            next: () => {
                              this.alertService.success('Vehicle Driver Mapping added Sucessfully !', { keepAfterRouteChange: true });
                              this.router.navigate(['../'], { relativeTo: this.route });
                            },
                            error: error => {
                              this.alertService.error(error);
                              this.loading = false;
                            }
                          });

                      } else {
                        console.log("Update Vehicle Driver Mapping : " + this.vehicleDriverMapping.mappingVehicleDriverDetailsId);
                        this.mappingVehicleDriverService.updateMappingVehicleDriver(this.vehicleDriverMapping.mappingVehicleDriverDetailsId, this.vehicleDriverMapping)
                          .pipe(first())
                          .subscribe({
                            next: () => {
                              this.alertService.warn('Vehicle Driver Mapping Updated Sucesssfully !', { keepAfterRouteChange: true });
                              this.router.navigate(['../../'], { relativeTo: this.route });
                            },
                            error: (error: string) => {
                              this.alertService.error(error);
                              this.loading = false;
                            }
                          });
                      }

                    },
                    error: (err) => {
                      console.log(err);
                    }
                  });

              },
              error: (err) => {
                console.log(err);
              }
            });
        },
        error: (err) => console.log(err)
      });
  }

  OnCancel(){
    this.router.navigate(['../'], { relativeTo: this.route });

  }

}
