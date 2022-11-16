import { Component, OnInit } from '@angular/core';
import { State } from 'src/app/modules/State';
import { StateServiceService } from 'src/app/Services/state-service.service';
import { first } from 'rxjs/operators';
import { User } from 'src/app/modules/masterUser';

@Component({
  selector: 'app-state-list',
  templateUrl: './state-list.component.html',
  styleUrls: ['./state-list.component.scss']
})
export class StateListComponent implements OnInit {
  states?: State[];
  isDeleting: boolean = false;
  constructor(private stateService: StateServiceService) { }
  currentUser: User
  ngOnInit(): void {
    this.isDeleting = false;
    this.stateService.getStateList()
      .pipe(first())
      .subscribe({
        next: (data) => {
          this.states = data;
          // console.log(data);
        },
        error: (error) => console.log(error)
      });

    let user = JSON.parse(localStorage.getItem("user") as any);//localStorage.getItem('user');
    this.currentUser = user;
    console.log(this.currentUser.firstName);

  }
  deleteState(stateId: number) {

    this.isDeleting = true;
    this.stateService.deleteState(stateId)
      .pipe(first())
      .subscribe(() => this.states = this.states?.filter(x => x.stateId !== stateId));
    this.isDeleting = false;
  }


}
