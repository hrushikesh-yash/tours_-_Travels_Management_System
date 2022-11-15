
import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { VehicleType } from 'src/app/modules/VehicleType';
import { AlertService } from 'src/app/Services/alert-service.service';
import { VehicleTypeService } from 'src/app/Services/vehicle-type.service';


@Component({
  selector: 'app-add-edit-vehicle-type',
  templateUrl: './add-edit-vehicle-type.component.html',
  styleUrls: ['./add-edit-vehicle-type.component.css']
})
export class AddEditVehicleTypeComponent implements OnInit {

  loading = false;
  isAddMode!: boolean;
  id!: number;
  VehicleTypeForm!: FormGroup;
  submitted = false;
  vehicleType: VehicleType = new VehicleType;
  // VehicleAddedDate =this.datepipe.transform(new Date(), 'yyyy-MM-dd');



  constructor(private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private VehicleTypeService: VehicleTypeService,
    private alertService: AlertService,
    public datepipe: DatePipe) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];
    this.isAddMode = !this.id;
    console.log(this.id);
    // console.log("vehicle added date :: "+this.VehicleAddedDate)

    this.VehicleTypeForm = this.formBuilder.group({
      vehicleTypeId: [this.id],
      vehicleTypeName: [''],
      vehicleTypeAddedDate: [''],
    });

    if (!this.isAddMode) {
      this.VehicleTypeService.findVehicleTypeById(this.id)
        .pipe(first())
        .subscribe(x => this.VehicleTypeForm.patchValue(x));
    }
  }

  onSubmit() {
    this.submitted = true;
    this.loading = true;
    this.vehicleType.vehicleTypeId = this.VehicleTypeForm.controls['vehicleTypeId'].value;
    this.vehicleType.vehicleTypeName = this.VehicleTypeForm.controls['vehicleTypeName'].value;
    this.vehicleType.vehicleTypeAddedDate = this.VehicleTypeForm.controls['vehicleTypeAddedDate'].value;


    if (this.isAddMode) {
      console.log(" Add state")


      this.VehicleTypeService.addVehicleType(this.VehicleTypeForm.value)
        .pipe(first())
        .subscribe({
          next: () => {
            this.alertService.success('Vehicle-Type added', { keepAfterRouteChange: true });
            this.router.navigate(['../'], { relativeTo: this.route });
          },
          error: error => {
            this.alertService.error(error);
            this.loading = false;
          }
        });

    } else {
      console.log("Update Vehicle Type: " + this.vehicleType.vehicleTypeId)
      this.VehicleTypeService.updateVehicleType(this.vehicleType.vehicleTypeId, this.vehicleType)
        .pipe(first())
        .subscribe({
          next: () => {
            this.alertService.warn('Vehicle Type Updated', { keepAfterRouteChange: true });
            this.router.navigate(['../../'], { relativeTo: this.route });
          },
          error: error => {
            this.alertService.error(error);
            this.loading = false;
          }
        });
    }
  }
}






