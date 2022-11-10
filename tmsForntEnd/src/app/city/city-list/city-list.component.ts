import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs';
import { City} from 'src/app/modules/City';
import { CityList } from 'src/app/modules/CityList';
import { CityServiceService } from 'src/app/Services/city-service.service';


@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.css']
})
export class CityListComponent implements OnInit {

  cities: City[];
  cityList:CityList[];
  isDeleting:boolean=false;
  constructor(private cityService: CityServiceService) { }

  ngOnInit(): void {
     this.isDeleting = false;
    this.cityService.getCityList()
      .pipe(first())
      .subscribe({
        next: (data) => {
          this.cityList = data;
          console.log(data);
        },
        error: (error) => console.log(error)
      });

  }
  deleteState(cityId: number) {

    this.isDeleting = true;
    this.cityService.deleteCity(cityId)
      .pipe(first())
      .subscribe(() => this.cities = this.cities?.filter(x => x.cityId !== cityId));
      this.isDeleting = false;
      this.isDeleting = false;
  }


}
