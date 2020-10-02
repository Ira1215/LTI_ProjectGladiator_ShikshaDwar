import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OfficerDashboardNavBarComponent } from './officer-dashboard-nav-bar.component';

describe('OfficerDashboardNavBarComponent', () => {
  let component: OfficerDashboardNavBarComponent;
  let fixture: ComponentFixture<OfficerDashboardNavBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OfficerDashboardNavBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OfficerDashboardNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
