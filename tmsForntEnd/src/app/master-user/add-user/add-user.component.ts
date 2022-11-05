import { DatePipe, formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/modules/masterUser';
import { UserService } from 'src/app/Services/UserService.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  addUserForm! : FormGroup;
  submitted=false;
  user: User = new User;
  userAddDate :Date = new Date();
  constructor(private userService:UserService,
    private formBuilder: FormBuilder,
    private router: Router,
    private datePipe: DatePipe) {
      
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

  onSubmit() 
  {
    this.submitted = true;

    // if (this.addUserForm.invalid) {
    //   return;
    // }

    // alert(
    //   'SUCCESS!! :-)\n\n' + JSON.stringify(this.addUserForm.value, null, 4)
    // );

    this.user.firstName=this.addUserForm.controls['firstName'].value;
    this.user.lastName=this.addUserForm.controls['lastName'].value;
    this.user.userName=this.addUserForm.controls['userName'].value;
    this.user.password=this.addUserForm.controls['password'].value;
    this.user.emailId=this.addUserForm.controls['emailId'].value;
    this.user.gender=this.addUserForm.controls['gender'].value;
    this.user.mobileNo=this.addUserForm.controls['mobileNo'].value;
    this.user.address=this.addUserForm.controls['address'].value;
    this.user.userIsCreated=new Date(formatDate(new Date(), 'yyyy/MM/dd', 'en'));
    this.user.useIsDeleted=0;
    
    console.log(this.user);

    this.userService.createUser(this.user)
      .subscribe( data =>{
        this.goToUserList();
      }
      ,error => console.log(error));
  }
  
    goToUserList() {
      this.router.navigate(['/masterUser']);
    }

}

