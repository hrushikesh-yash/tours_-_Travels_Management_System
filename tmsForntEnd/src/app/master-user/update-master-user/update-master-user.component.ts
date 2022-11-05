import { Component, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/modules/masterUser';
import { UserService } from 'src/app/Services/UserService.service';
import { MasterUserComponent } from '../master-user.component';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-master-user',
  templateUrl: './update-master-user.component.html',
  styleUrls: ['./update-master-user.component.css']
})
export class UpdateMasterUserComponent implements OnInit {
    
  user!:User;
  registerForm !: FormGroup;
  submitted=false;
  userId!:number;
  constructor(private http:HttpClient,
        private userService:UserService,
        private formBuilder: FormBuilder,
        private router: Router) { }
  
  
  ngOnInit(): void {
    this.getUserDetails();
    this.registerForm = this.formBuilder.group(
      {
        firstName: [''],
        lastName: [''],
        emailId: ['']
      
      });
  }

  getUserDetails()
  {
    this.userId=this.userService.getUserId()

    this.userService.findUserById(this.userId)
    .subscribe({
      next: (data) => {
        this.user = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  onSubmit() 
  {
      this.submitted = true;
  
      if (this.registerForm.invalid) {
        return;
      }
  
      alert(
        'SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value, null, 4)
      );

      this.user.firstName=this.registerForm.controls['firstName'].value;
      this.user.lastName=this.registerForm.controls['lastName'].value;
      this.user.emailId=this.registerForm.controls['emailId'].value;

      console.log(this.user);

      this.userService.updateUser(this.user.userId,this.user)
      .subscribe( data =>{
        this.goToUserList();
      }
      , error => console.log(error));
    }
  
    goToUserList() {
    this.router.navigate(['/masterUser']);
  }
  
  
    
   
}
