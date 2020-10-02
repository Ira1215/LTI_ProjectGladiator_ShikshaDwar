import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NodalStudentDetailFetchComponent } from './nodal-student-detail-fetch.component';

describe('NodalStudentDetailFetchComponent', () => {
  let component: NodalStudentDetailFetchComponent;
  let fixture: ComponentFixture<NodalStudentDetailFetchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NodalStudentDetailFetchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NodalStudentDetailFetchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
