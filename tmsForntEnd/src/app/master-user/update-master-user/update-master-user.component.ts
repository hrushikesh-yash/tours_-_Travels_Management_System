import { Component, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/modules/masterUser';
import { UserService } from 'src/app/Services/UserService.service';
import { MasterUserComponent } from '../master-user.component';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-update-master-user',
  templateUrl: './update-master-user.component.html',
  styleUrls: ['./update-master-user.component.css']
})
export class UpdateMasterUserComponent implements OnInit {
    
  user!:User;
  // registerForm !: FormGroup;
  // submitted=false;
  userId!:number;
  constructor(private http:HttpClient,
        private userService:UserService,
        private formBuilder: FormBuilder ) { }
  
  
  ngOnInit(): void {

    // this.registerForm = this.formBuilder.group(
    //     {
    //       firstName: [this.user.firstName],
    //       lastName: [this.user.lastName],
    //       emailId: [this.user.emailId]
        
    //     });

    this.getUserDetails();
  }

  getUserDetails()
  {
    this.userId=this.userService.getUserId()
    console.log("user id : "+this.userId);

    this.userService.findUserById(this.userId)
    .subscribe({
      next: (data) => {
        this.user = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  // onSubmit() {
  //     this.submitted = true;
  
  //     if (this.registerForm.invalid) {
  //       return;
  //     }
  
  //     alert(
  //       'SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value, null, 4)
  //     );
  //   }
}
