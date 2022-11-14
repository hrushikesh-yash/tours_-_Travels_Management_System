import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs';
import { CityRoutes } from 'src/app/modules/CityRoutes';
import { User } from 'src/app/modules/masterUser';
import { CityRoutesService } from 'src/app/Services/city-routes.service';

@Component({
  selector: 'app-city-routes-list',
  templateUrl: './city-routes-list.component.html',
  styleUrls: ['./city-routes-list.component.css']
})
export class CityRoutesListComponent implements OnInit {

  cityRoutes:CityRoutes[];
  currentUser:User;

  isDeleting:boolean=false;
  constructor(private cityRoutesService: CityRoutesService) { }

  ngOnInit(): void {
     this.isDeleting = false;
    this.cityRoutesService.findAllRoutes()
      .pipe(first())
      .subscribe({
        next: (data) => {
          this.cityRoutes = data;
          console.log(data);
        },
        error: (error) => console.log(error)
      });

      let user = JSON.parse(localStorage.getItem("user") as any);//localStorage.getItem('user');
    this.currentUser = user;

  }
  deleteState(routeId: number) {

    this.isDeleting = true;
    this.cityRoutesService.deleteRoute(routeId)
      .pipe(first())
      .subscribe(() => this.cityRoutes = this.cityRoutes.filter(x => x.routeId !== routeId));
      this.isDeleting = false;
      this.isDeleting = false;
  }

}
