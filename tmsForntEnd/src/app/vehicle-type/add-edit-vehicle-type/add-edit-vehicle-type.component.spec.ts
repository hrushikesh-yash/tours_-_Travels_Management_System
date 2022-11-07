import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditVehicleTypeComponent } from './add-edit-vehicle-type.component';

describe('AddEditVehicleTypeComponent', () => {
  let component: AddEditVehicleTypeComponent;
  let fixture: ComponentFixture<AddEditVehicleTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEditVehicleTypeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddEditVehicleTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
