import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs';
import { City, CityToView } from 'src/app/modules/City';
import { CityServiceService } from 'src/app/Services/city-service.service';

@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.css']
})
export class CityListComponent implements OnInit {

  cities?: City[];
  cityToView?:CityToView[];
  isDeleting:boolean=false;
  constructor(private cityService: CityServiceService) { }

  ngOnInit(): void {
     this.isDeleting = false;
    this.cityService.getCityList()
      .pipe(first())
      .subscribe({
        next: (data) => {
          this.cities = data;
          console.log(data);
        },
        error: (error) => console.log(error)
      });

  }
  deleteState(cityId: number) {

    this.isDeleting = true;
    this.cityService.deleteCity(cityId)
      .pipe(first())
      .subscribe(() => this.cities = this.cities?.filter(x => x.stateId !== cityId));
      this.isDeleting = false;
      this.isDeleting = false;
  }


}
