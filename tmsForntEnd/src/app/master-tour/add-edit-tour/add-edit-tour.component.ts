import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { City } from 'src/app/modules/City';
import { Tour } from 'src/app/modules/Tour';
import { AlertService } from 'src/app/Services/alert-service.service';
import { CityServiceService } from 'src/app/Services/city-service.service';
import { TourService } from 'src/app/Services/tour.service';

@Component({
  selector: 'app-add-edit-tour',
  templateUrl: './add-edit-tour.component.html',
  styleUrls: ['./add-edit-tour.component.css']
})
export class AddEditTourComponent implements OnInit {

  loading = false;
  isAddMode!: boolean;
  id!: number;
  tourForm: FormGroup;
  submitted = false;
  cities?: City[];
  tour: Tour = new Tour;
  stateId: number = 0;

  constructor(private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private alertService: AlertService,
    private cityService: CityServiceService,
    private tourService:TourService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.isAddMode = !this.id;

    this.tourForm = this.formBuilder.group({
      tourId: [this.id],
      tourName: [''],
      tourDescription:[''],
      tourPrice: [''],
      cityId: [''],
    });

    this.cityService.getCityList()
      .pipe(first())
      .subscribe({
        next: (data) => {
          this.cities = data;
        },
        error: (error) => console.log(error)
      });


      if (!this.isAddMode) {
        this.tourService.findTourById(this.id)
          .pipe(first())
          .subscribe(x => this.tourForm.patchValue(x));
      }

  }

  onSubmit() {
    this.submitted = true;
    this.loading = true;
    this.tour.tourId = this.tourForm.controls['tourId'].value;
    this.tour.tourName = this.tourForm.controls['tourName'].value;
    this.tour.tourDescription = this.tourForm.controls['tourDescription'].value;
    this.tour.tourPrice = this.tourForm.controls['tourPrice'].value;
    this.tour.cityId = this.tourForm.controls['cityId'].value;

    console.log(this.tour);
    if (this.isAddMode) {
      console.log(" Add Tour");


          this.tourService.addTour(this.tour)
            .pipe(first())
            .subscribe({
              next: () => {
                this.alertService.success('Tour Added Sucessfully !', { keepAfterRouteChange: true });
                this.router.navigate(['../'], { relativeTo: this.route });
              },
              error: error => {
                this.alertService.error(error);
                this.loading = false;
              }
            });

    } else {
      console.log("Update state: " + this.tour.tourId);
           this.tourService.updateTour(this.tour.tourId,this.tour)
                .pipe(first())
                .subscribe({
                    next: () => {
                        this.alertService.warn('Tour Updated Sucesssfully !', { keepAfterRouteChange: true });
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
