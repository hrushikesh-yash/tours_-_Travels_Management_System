import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { City } from 'src/app/modules/City';
import { CityRoutes } from 'src/app/modules/CityRoutes';
import { AlertService } from 'src/app/Services/alert-service.service';
import { CityRoutesService } from 'src/app/Services/city-routes.service';
import { CityServiceService } from 'src/app/Services/city-service.service';

@Component({
  selector: 'app-add-edit-city-routes',
  templateUrl: './add-edit-city-routes.component.html',
  styleUrls: ['./add-edit-city-routes.component.scss']
})
export class AddEditCityRoutesComponent implements OnInit {

  loading = false;
  isAddMode!: boolean;
  id!: number;
  cityRouteForm: FormGroup;
  sourceCity: City;
  destinationCity: City;
  submitted = false;
  cities: City[];
  cityRoute: CityRoutes = new CityRoutes;
  sourceCityId: number = 0;
  destinationCityId:number=0;
  constructor(private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private cityRoutesService: CityRoutesService,
    private alertService: AlertService,
    private cityService: CityServiceService) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];
    console.log("this id :: " + this.id)
    this.isAddMode = !this.id;



    this.cityService.getCityList()
      .pipe(first())
      .subscribe({
        next: (data) => {
          this.cities = data;
          console.log(this.cities);
        },
        error: (error) => console.log(error)
      });

    this.cityRouteForm = this.formBuilder.group({
      routeId: [this.id],
      routeName: [''],
      sourceCityId: [''],
      destinationCityId: [''],
      routeCreatedDate: [''],
      routePrice:['']
    });

    if (!this.isAddMode) {
      this.cityRoutesService.findRouteById(this.id)
        .pipe(first())
        .subscribe(x => 
          this.cityRouteForm.patchValue(x)
          );
    }


  }

  onSubmit() {
    this.submitted = true;
    this.loading = true;
    this.cityRoute.routeId = this.cityRouteForm.controls['routeId'].value;
    this.cityRoute.routeName = this.cityRouteForm.controls['routeName'].value;
    this.cityRoute.routeCreatedDate = this.cityRouteForm.controls['routeCreatedDate'].value;
    this.sourceCityId=this.cityRouteForm.controls['sourceCityId'].value;
    console.log(this.sourceCityId);
    this.destinationCityId=this.cityRouteForm.controls['destinationCityId'].value;
    console.log(this.destinationCityId);
    console.log(this.cityRouteForm.controls['routePrice'].value)
    this.cityRoute.routePrice=this.cityRouteForm.controls['routePrice'].value;
    console.log(this.cityRoute)
    this.cityService.findCityById(this.sourceCityId)
      .pipe(first())
      .subscribe({
        next: (data) => {
          this.sourceCity = data;

          this.cityService.findCityById(this.destinationCityId)
            .pipe(first())
            .subscribe({
              next: (data) => {
                this.destinationCity = data;

                this.cityRoute.sourceCity = this.sourceCity;
                this.cityRoute.destinationCity = this.destinationCity;

                if (this.isAddMode) {
                  console.log(" Add City Route");


                  this.cityRoutesService.addRoutes(this.cityRoute)
                    .pipe(first())
                    .subscribe({
                      next: () => {
                        this.alertService.success('City Route added Sucessfully !', { keepAfterRouteChange: true });
                        this.router.navigate(['../'], { relativeTo: this.route });
                      },
                      error: error => {
                        this.alertService.error(error);
                        this.loading = false;
                      }
                    });

                } else {
                  // console.log("Update state: " + this.cityRoute.routeId);
                  this.cityRoutesService.updateRoute(this.cityRoute.routeId, this.cityRoute)
                    .pipe(first())
                    .subscribe({
                      next: () => {
                        this.alertService.warn('City Route Updated Sucesssfully !', { keepAfterRouteChange: true });
                        this.router.navigate(['../../'], { relativeTo: this.route });
                      },
                      error: (error: string) => {
                        this.alertService.error(error);
                        this.loading = false;
                      }
                    });
                }

              }
            });


        }
      });



    // console.log(this.city);



  }

  OnCancel(){
    if(this.isAddMode)
    {
      this.router.navigate(['../'], { relativeTo: this.route });
    }
    else
    {
      this.router.navigate(['../../'], { relativeTo: this.route });
    }

  }

}
