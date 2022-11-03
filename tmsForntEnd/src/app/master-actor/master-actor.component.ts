import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-master-actor',
  templateUrl: './master-actor.component.html',
  styleUrls: ['./master-actor.component.css']
})
export class MasterActorComponent implements OnInit {
 
  submitted = false;
  form = this.formBuilder.group(
    {
      actorName: [''],
      actorDescription: ['']
    });
  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    
  }

  // get f(): { [key: string]: AbstractControl } {
  //   return this.form.controls;
  // }

  onSubmit(): void {
    this.submitted = true;

    // if (this.form.invalid) {
    //   return;
    // }

    console.log(JSON.stringify(this.form.value, null, 2));
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
  }
}
