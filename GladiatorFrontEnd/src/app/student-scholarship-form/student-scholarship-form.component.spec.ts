import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentScholarshipFormComponent } from './student-scholarship-form.component';

describe('StudentScholarshipFormComponent', () => {
  let component: StudentScholarshipFormComponent;
  let fixture: ComponentFixture<StudentScholarshipFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentScholarshipFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentScholarshipFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
