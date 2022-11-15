import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs';
import { City} from 'src/app/modules/City';
import { CityList } from 'src/app/modules/CityList';
import { User } from 'src/app/modules/masterUser';
import { CityServiceService } from 'src/app/Services/city-service.service';


@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.css']
})
export class CityListComponent implements OnInit {

  cities: City[];
  cityList:City[];
  isDeleting:boolean=false;
  currentUser:User;

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

      let user = JSON.parse(localStorage.getItem("user") as any);//localStorage.getItem('user');
    this.currentUser = user;
    console.log(this.currentUser.firstName);

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
