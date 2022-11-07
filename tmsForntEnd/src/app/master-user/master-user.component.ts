import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../modules/masterUser';
import { UserService } from '../Services/UserService.service';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router} from '@angular/router'

@Component({
  selector: 'app-master-user',
  templateUrl: './master-user.component.html',
  styleUrls: ['./master-user.component.css']
})
export class MasterUserComponent implements OnInit {
  // userRegisterForm!: FormGroup ;

  users?: User[];
  submitted = false;
  registerForm !: FormGroup;
  userImage: String ="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRS7lVd-MZ41Dj-AYVtJMuJmSS7f_CiNcrUhQ&usqp=CAU";
  constructor(private route: ActivatedRoute, 
    private router: Router,
    private http:HttpClient,
    private formBuilder: FormBuilder,
    private userService:UserService) {}
 
  ngOnInit() {
    this.getUserDetails();
  }

  getUserDetails()
  {
    this.userService.getUserList()
    .subscribe({
      next: (data) => {
        this.users = data;
        // console.log(this.users);
      },
      error: (e) => console.error(e)
    });
  }

  updateUser(userId: number)
  {
    console.log(userId);
    this.userService.sharedDate(userId);
    this.router.navigate([userId], { relativeTo: this.route });
  }

  deleteUser(userId: number)
  {
    console.log(userId);
    this.userService.deleteUser(userId)
    .subscribe({
      next: (data) => {
        
         console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  goToUserList()
  {
    this.router.navigate(['masterUser']);
  }

  
    // this.registerForm = this.formBuilder.group(
    //   {
    //     firstName: [''],
    //     lastName: [''],
    //     emailId: ['']
      
    //   },
  
    // );
  
  // userRegisterForm = this.formBuilder.group(
  //   {
  //     firstName: ['', Validators.required],
  //     lastName: ['', Validators.required],
  //     userName: ['', Validators.required],
  //     password: ['', Validators.required],
  //     email: ['', [Validators.required, Validators.email]],
  //     address: ['', Validators.required],
  //     mobile: ['', Validators.required],
  //     gender: ['']
      
  //   });

  // get f() {
  //   return this.registerForm.controls;
  // }

  // onSubmit() {
  //   this.submitted = true;

  //   if (this.registerForm.invalid) {
  //     return;
  //   }

  //   alert(
  //     'SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value, null, 4)
  //   );
  // }

  // onReset() {
  //   this.submitted = false;
  //   this.registerForm.reset();
  // }

}
