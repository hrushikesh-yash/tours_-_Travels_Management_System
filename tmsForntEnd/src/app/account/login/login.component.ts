import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { User } from 'src/app/modules/masterUser';
import { AlertService } from 'src/app/Services/alert-service.service';
import { UserService } from 'src/app/Services/UserService.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  user: User;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private accountService: UserService,
    private alertService: AlertService
  ) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: [''],
      password: ['']
    });

    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  // convenience getter for easy access to form fields
  //get f() { return this.loginForm.controls; }

  onSubmit() {
    this.submitted = true;

    // reset alerts on submit
    this.alertService.clear();

    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }

    this.loading = true;
    this.accountService.login(this.loginForm.controls['username'].value, this.loginForm.controls['password'].value)
      .pipe(first())
      .subscribe({
        next: (data: User) => {
          this.user = data;
          // console.log(this.user);
          this.accountService.shareLoginUser(this.user);
          this.alertService.success(this.user.firstName +' Login Sucesssfully !', { keepAfterRouteChange: true });
          this.router.navigate(['../Dashboard'], { relativeTo: this.route });
          // .then(() => {
          //   //window.location.reload();
          // });
          localStorage.setItem('user', JSON.stringify(this.user))
        },
        error: (err) => {
          this.alertService.error(err.error.message, { keepAfterRouteChange: true });
            this.loading = false;
        }
      });


  }

  gotoDashboard()
  {
    this.router.navigate(['../Dashboard'], { relativeTo: this.route });
  }
}
