import { DatePipe, formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/modules/masterUser';
import { AlertService } from 'src/app/Services/alert-service.service';
import { UserService } from 'src/app/Services/UserService.service';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.scss']
})
export class EditUSerComponent implements OnInit {

  addUserForm!: FormGroup;
  submitted = false;
  user: User = new User;
  currentUser:User;
  userAddDate: Date = new Date();
  constructor(private userService: UserService,
    private formBuilder: FormBuilder,
    private router: Router,
    private datePipe: DatePipe,
    private alertService: AlertService) {

  }

  ngOnInit(): void {
    let user = JSON.parse(localStorage.getItem("user") as any);//localStorage.getItem('user');
    this.currentUser = user; 
    console.log(this.currentUser);
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

      this.addUserForm.patchValue(this.currentUser);
  }

  onSubmit() {
    this.submitted = true;

    // if (this.addUserForm.invalid) {
    //   return;
    // }

    this.alertService.success('User added Sucessfully !', { keepAfterRouteChange: true });

    this.user.firstName = this.addUserForm.controls['firstName'].value;
    this.user.lastName = this.addUserForm.controls['lastName'].value;
    this.user.userName = this.addUserForm.controls['userName'].value;
    this.user.password = this.addUserForm.controls['password'].value;
    this.user.emailId = this.addUserForm.controls['emailId'].value;
    this.user.gender = this.addUserForm.controls['gender'].value;
    this.user.mobileNo = this.addUserForm.controls['mobileNo'].value;
    this.user.address = this.addUserForm.controls['address'].value;
    // this.user.userIsCreated = new Date(formatDate(new Date(), 'yyyy/MM/dd', 'en'));
    this.user.useIsDeleted = 0;

    console.log(this.user);

    this.userService.createUser(this.user)
      .subscribe(data => {
        this.router.navigate(['../']);
      }
        , error => console.log(error));
  }

  onCancel()
  {
    this.router.navigate(['../']);
  }

}
