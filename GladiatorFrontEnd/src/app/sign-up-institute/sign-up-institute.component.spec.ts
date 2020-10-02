import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SignUpInstituteComponent } from './sign-up-institute.component';

describe('SignUpInstituteComponent', () => {
  let component: SignUpInstituteComponent;
  let fixture: ComponentFixture<SignUpInstituteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SignUpInstituteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignUpInstituteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
