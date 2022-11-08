import { state } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { State } from 'src/app/modules/State';
import { AlertService } from 'src/app/Services/alert-service.service';
import { StateServiceService } from 'src/app/Services/state-service.service';

@Component({
  selector: 'app-add-edit-state',
  templateUrl: './add-edit-state.component.html',
  styleUrls: ['./add-edit-state.component.css']
})
export class AddEditStateComponent implements OnInit {

  loading = false;
  isAddMode!: boolean;
  id!: number;
  stateForm!: FormGroup;
  submitted = false;
  state: State = new State;

  constructor(private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private stateService: StateServiceService,
    private alertService: AlertService) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'].getValue();
    this.isAddMode = !this.id;
<<<<<<< HEAD
    //  console.log(this.id);
=======
    // console.log(this.id);
>>>>>>> a883caf69a40871958203f2c8411b457798c627d
    this.stateForm = this.formBuilder.group({
      stateId: [this.id],
      stateName: [''],
      stateCode: [''],

    });

    if (!this.isAddMode) {
      this.stateService.findStateById(this.id)
        .pipe(first())
        .subscribe(x => this.stateForm.patchValue(x));
    }

  }

  onSubmit() {
    this.submitted = true;
    this.loading = true;
    this.state.stateId = this.stateForm.controls['stateId'].value;
    this.state.stateName = this.stateForm.controls['stateName'].value;
    this.state.stateCode = this.stateForm.controls['stateCode'].value;

    if (this.isAddMode) {
      console.log(" Add state")


      this.stateService.addState(this.stateForm.value)
        .pipe(first())
        .subscribe({
          next: () => {
            this.alertService.success('User added', { keepAfterRouteChange: true });
            this.router.navigate(['../'], { relativeTo: this.route });
          },
          error: error => {
            this.alertService.error(error);
            this.loading = false;
          }
        });

    } else {
      console.log("Update state: " + this.state.stateId)
       this.stateService.updateState(this.state.stateId, this.state)
            .pipe(first())
            .subscribe({
                next: () => {
                    this.alertService.warn('State Updated', { keepAfterRouteChange: true });
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
