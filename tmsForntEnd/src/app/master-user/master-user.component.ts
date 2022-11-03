import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-master-user',
  templateUrl: './master-user.component.html',
  styleUrls: ['./master-user.component.css']
})
export class MasterUserComponent implements OnInit {
  // userRegisterForm!: FormGroup ;
  submitted = false;
  registerForm !: FormGroup;
  constructor(private formBuilder: FormBuilder) {}
 
  ngOnInit() {
    this.registerForm = this.formBuilder.group(
      {
        firstName: [''],
        lastName: [''],
        emailId: ['']
      
      },
  
    );
  }
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

  get f() {
    return this.registerForm.controls;
  }

  onSubmit() {
    this.submitted = true;

    if (this.registerForm.invalid) {
      return;
    }

    alert(
      'SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value, null, 4)
    );
  }

  onReset() {
    this.submitted = false;
    this.registerForm.reset();
  }

}
