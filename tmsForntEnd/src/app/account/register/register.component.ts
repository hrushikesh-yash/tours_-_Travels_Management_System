import { DatePipe, formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { first } from 'rxjs';
import { Actor } from 'src/app/modules/Admin';
import { User } from 'src/app/modules/masterUser';
import { ActorService } from 'src/app/Services/admin.service';
import { AlertService } from 'src/app/Services/alert-service.service';
import { UserService } from 'src/app/Services/UserService.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  addUserForm!: FormGroup;
  submitted = false;
  user: User = new User;
  userAddDate: Date = new Date();
  actorId: number = 2;
  actor: Actor;
  userAfterAdded: User;

  constructor(private userService: UserService,
    private formBuilder: FormBuilder,
    private router: Router,
    private datePipe: DatePipe,
    private alertService: AlertService,
    private actorService: ActorService) {

  }

  ngOnInit(): void {

    this.addUserForm = this.formBuilder.group(
      {
        firstName: [''],
        lastName: [''],
        userName: [''],
        password: [''],
        emailId: [''],
        gender: [''],
        mobileNo: [''],
        address: ['']
      });
  }

  onSubmit() {
    this.submitted = true;

    // if (this.addUserForm.invalid) {
    //   return;
    // }

    

    this.user.firstName = this.addUserForm.controls['firstName'].value;
    this.user.lastName = this.addUserForm.controls['lastName'].value;
    this.user.userName = this.addUserForm.controls['userName'].value;
    this.user.password = this.addUserForm.controls['password'].value;
    this.user.emailId = this.addUserForm.controls['emailId'].value;
    this.user.gender = this.addUserForm.controls['gender'].value;
    this.user.mobileNo = this.addUserForm.controls['mobileNo'].value;
    this.user.address = this.addUserForm.controls['address'].value;

    this.user.useIsDeleted = 0;

    // this.user.actor.actorId = this.actorId

    this.actorService.findActorById(this.actorId)
    .pipe(first())
    .subscribe({
      next:(data) =>{
        this.user.actor=data

        this.userService.createUser(this.user)
        .pipe(first())
        .subscribe({
          next: (data) => {
            this.userAfterAdded = data;
            console.log(this.userAfterAdded);
          },
          error: (err) => {
            this.alertService.error(err);
          },
          complete: () => {
            this.alertService.success('User added Sucessfully !', { keepAfterRouteChange: true });
            this.router.navigate(['../']);
          }
  
        });

      },
      error :(err) => 
      this.alertService.error(err)
    });

   

  }

  onCancel() {
    this.router.navigate(['../']);
  }



}
