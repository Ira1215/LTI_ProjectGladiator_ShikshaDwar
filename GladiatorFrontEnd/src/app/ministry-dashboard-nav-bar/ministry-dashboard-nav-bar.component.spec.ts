import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MinistryDashboardNavBarComponent } from './ministry-dashboard-nav-bar.component';

describe('MinistryDashboardNavBarComponent', () => {
  let component: MinistryDashboardNavBarComponent;
  let fixture: ComponentFixture<MinistryDashboardNavBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MinistryDashboardNavBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MinistryDashboardNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
