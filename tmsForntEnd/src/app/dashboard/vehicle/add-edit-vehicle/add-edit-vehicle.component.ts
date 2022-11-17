import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { Vehicle } from 'src/app/modules/Vehicle';
import { VehicleType } from 'src/app/modules/VehicleType';
import { AlertService } from 'src/app/Services/alert-service.service';
import { VehicleTypeService } from 'src/app/Services/vehicle-type.service';
import { VehicleService } from 'src/app/Services/vehicle.service';

@Component({
  selector: 'app-add-edit-vehicle',
  templateUrl: './add-edit-vehicle.component.html',
  styleUrls: ['./add-edit-vehicle.component.scss']
})
export class AddEditVehicleComponent implements OnInit {

  loading = false;
  isAddMode: boolean;
  id: number;
  vehicleForm: FormGroup;
  submitted = false;
  vehicleTypes: VehicleType[];
  vehicle: Vehicle = new Vehicle;
  vehicleType: VehicleType = new VehicleType;
  vehicleTypeId: number = 0;

  constructor(private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private vehicleTypeService: VehicleTypeService,
    private alertService: AlertService,
    private vehicleService: VehicleService) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];
    this.isAddMode = !this.id;



    this.vehicleTypeService.getVehicleTypeList()
      .pipe(first())
      .subscribe({
        next: (data) => {
          this.vehicleTypes = data;
        },
        error: (error) => console.log(error)
      });

    this.vehicleForm = this.formBuilder.group({
      vehicleId: [this.id],
      vehicleName: [''],
      companyName: [''],
      vehicleTypeId: [''],
      vehicleCapcity: [''],
      vehicleprice:['']
    });

    if (!this.isAddMode) {
      // console.log("mode: "+this.isAddMode);
      this.vehicleService.findVehicleById(this.id)
        .pipe(first())
        .subscribe(x => this.vehicleForm.patchValue(x));
    }


  }

  onSubmit() {
    this.submitted = true;
    this.loading = true;
    this.vehicle.vehicleId = this.vehicleForm.controls['vehicleId'].value;
    this.vehicle.vehicleName = this.vehicleForm.controls['vehicleName'].value;
    this.vehicle.vehicleCapcity = this.vehicleForm.controls['vehicleCapcity'].value;
    this.vehicle.companyName = this.vehicleForm.controls['companyName'].value;

    this.vehicleTypeService.findVehicleTypeById(this.vehicle.vehicleType = this.vehicleForm.controls['vehicleTypeId'].value)
      .pipe(first())
      .subscribe({
        next: (data) => {
          this.vehicleType = data;
          this.vehicle.vehicleType = this.vehicleType;

          console.log(this.vehicle);
          if (this.isAddMode) {
            console.log(" Add City");


            this.vehicleService.addVehicleDetails(this.vehicle)
              .pipe(first())
              .subscribe({
                next: () => {
                  this.alertService.success('Vehicle addedSucessfully !', { keepAfterRouteChange: true });
                  this.router.navigate(['../'], { relativeTo: this.route });
                },
                error: error => {
                  this.alertService.error(error);
                  this.loading = false;
                }
              });

          } else {
            console.log("Update Vehicle: " + this.vehicle.vehicleId);
            this.vehicleService.updateVehicle(this.vehicle.vehicleId, this.vehicle)
              .pipe(first())
              .subscribe({
                next: () => {
                  this.alertService.warn('Vehicle Updated Sucesssfully !', { keepAfterRouteChange: true });
                  this.router.navigate(['../../'], { relativeTo: this.route });
                },
                error: (error: string) => {
                  this.alertService.error(error);
                  this.loading = false;
                }
              });
          }
        },
        error: (error) => console.log(error)
      });
  }

  OnCancel(){
    this.router.navigate(['../'], { relativeTo: this.route });

  }
}
