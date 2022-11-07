import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Tour } from 'src/app/modules/Tour';
import { TourService } from 'src/app/Services/tour.service';

@Component({
  selector: 'app-tour-list',
  templateUrl: './tour-list.component.html',
  styleUrls: ['./tour-list.component.css']
})
export class TourListComponent implements OnInit {

  tours?:Tour[];

  submitted = false;

  userImage: String ="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRS7lVd-MZ41Dj-AYVtJMuJmSS7f_CiNcrUhQ&usqp=CAU";

  constructor(private route: ActivatedRoute, 
    private router: Router,
    private http:HttpClient,
    private formBuilder: FormBuilder,
    private tourService:TourService) { }

  ngOnInit(): void {
    this.getTourList()
  }

  getTourList()
  {
    this.tourService.getTourList()
    .subscribe({
      next: (data) => {
        this.tours = data;
        console.log(this.tours);
      },
      error: (e) => console.error(e)
    });
  }

  updateTour(tourId: number)
  {
    console.log(tourId);
    // this.userService.sharedDate(userId);
    // this.router.navigate([userId], { relativeTo: this.route });
  }

  deleteTour(tourId: number)
  {
    console.log(tourId);
    this.tourService.deleteTour(tourId)
    .subscribe({
      next: (data) => {
        
         console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

}
