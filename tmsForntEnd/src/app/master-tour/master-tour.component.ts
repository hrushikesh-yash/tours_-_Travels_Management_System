import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-master-tour',
  templateUrl: './master-tour.component.html',
  styleUrls: ['./master-tour.component.css']
})
export class MasterTourComponent implements OnInit {
  // submitted = false;
  // form = this.formBuilder.group(
  //   {
  //     tourName: [''],
  //     tourDescription: [''],
  //     cityId:[''],
  //     tourPrice:['']
  //   });
  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    
  }

  // get f(): { [key: string]: AbstractControl } {
  //   return this.form.controls;
  // }

  // onSubmit(): void {
  //   this.submitted = true;

  //   // if (this.form.invalid) {
  //   //   return;
  //   // }

  //   console.log(JSON.stringify(this.form.value, null, 2));
  // }

  // onReset(): void {
  //   this.submitted = false;
  //   this.form.reset();
  // }
}
