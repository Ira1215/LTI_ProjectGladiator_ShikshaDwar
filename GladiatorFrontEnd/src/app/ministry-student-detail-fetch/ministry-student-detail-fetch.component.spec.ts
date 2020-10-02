import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MinistryStudentDetailFetchComponent } from './ministry-student-detail-fetch.component';

describe('MinistryStudentDetailFetchComponent', () => {
  let component: MinistryStudentDetailFetchComponent;
  let fixture: ComponentFixture<MinistryStudentDetailFetchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MinistryStudentDetailFetchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MinistryStudentDetailFetchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
