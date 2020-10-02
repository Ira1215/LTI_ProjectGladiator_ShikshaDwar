import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentTrackApplicationStatusComponent } from './student-track-application-status.component';

describe('StudentTrackApplicationStatusComponent', () => {
  let component: StudentTrackApplicationStatusComponent;
  let fixture: ComponentFixture<StudentTrackApplicationStatusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentTrackApplicationStatusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentTrackApplicationStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
