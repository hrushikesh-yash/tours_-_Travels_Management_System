import { state } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { City } from 'src/app/modules/City';
import { State } from 'src/app/modules/State';
import { AlertService } from 'src/app/Services/alert-service.service';
import { CityServiceService } from 'src/app/Services/city-service.service';
import { StateServiceService } from 'src/app/Services/state-service.service';

@Component({
  selector: 'app-add-edit-city',
  templateUrl: './add-edit-city.component.html',
  styleUrls: ['./add-edit-city.component.css']
})
export class AddEditCityComponent implements OnInit {
  loading = false;
  isAddMode!: boolean;
  id!: number;
  cityForm!: FormGroup;
  submitted = false;
  states?: State[];
  city: City = new City;
  state: State = new State;
  stateId: number = 0;

  constructor(private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private stateService: StateServiceService,
    private alertService: AlertService,
    private cityService: CityServiceService) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];
    this.isAddMode = !this.id;

   

    this.stateService.getStateList()
      .pipe(first())
      .subscribe({
        next: (data) => {
          this.states = data;
        },
        error: (error) => console.log(error)
      });

    this.cityForm = this.formBuilder.group({
      cityId: [this.id],
      cityName: [''],
      pinCode: [''],
      stateId: [''],
    });

    if (!this.isAddMode) {
      console.log("mode: "+this.isAddMode);
      this.cityService.findCityById(this.id)
        .pipe(first())
        .subscribe(x => this.cityForm.patchValue(x));
    }


  }

  onSubmit() {
    this.submitted = true;
    this.loading = true;
    this.city.cityId = this.cityForm.controls['cityId'].value;
    this.city.cityName = this.cityForm.controls['cityName'].value;
    this.city.pinCode = this.cityForm.controls['pinCode'].value;
    this.city.stateId = this.cityForm.controls['stateId'].value;

    console.log(this.city);
    if (this.isAddMode) {
      console.log(" Add City");


          this.cityService.addCity(this.city)
            .pipe(first())
            .subscribe({
              next: () => {
                this.alertService.success('City addedSucessfully !', { keepAfterRouteChange: true });
                this.router.navigate(['../'], { relativeTo: this.route });
              },
              error: error => {
                this.alertService.error(error);
                this.loading = false;
              }
            });

    } else {
      console.log("Update state: " + this.city.cityId);
           this.cityService.updateCity(this.city.cityId,this.city)
                .pipe(first())
                .subscribe({
                    next: () => {
                        this.alertService.warn('City Updated Sucesssfully !', { keepAfterRouteChange: true });
                        this.router.navigate(['../../'], { relativeTo: this.route });
                    },
                    error: (error: string) => {
                        this.alertService.error(error);
                        this.loading = false;
                    }
                });
    }


  }

}
