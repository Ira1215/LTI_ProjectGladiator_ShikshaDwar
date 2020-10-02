import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentDashboardNavBarComponent } from './student-dashboard-nav-bar.component';

describe('StudentDashboardNavBarComponent', () => {
  let component: StudentDashboardNavBarComponent;
  let fixture: ComponentFixture<StudentDashboardNavBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentDashboardNavBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentDashboardNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
