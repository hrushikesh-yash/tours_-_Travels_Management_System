import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MasterTourComponent } from './master-tour.component';

describe('MasterTourComponent', () => {
  let component: MasterTourComponent;
  let fixture: ComponentFixture<MasterTourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MasterTourComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MasterTourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
