import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InstituteStudentDetailFetchComponent } from './institute-student-detail-fetch.component';

describe('InstituteStudentDetailFetchComponent', () => {
  let component: InstituteStudentDetailFetchComponent;
  let fixture: ComponentFixture<InstituteStudentDetailFetchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InstituteStudentDetailFetchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InstituteStudentDetailFetchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
