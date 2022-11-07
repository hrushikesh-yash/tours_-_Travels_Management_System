import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MasterActorComponent } from './master-actor.component';

describe('MasterActorComponent', () => {
  let component: MasterActorComponent;
  let fixture: ComponentFixture<MasterActorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MasterActorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MasterActorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
