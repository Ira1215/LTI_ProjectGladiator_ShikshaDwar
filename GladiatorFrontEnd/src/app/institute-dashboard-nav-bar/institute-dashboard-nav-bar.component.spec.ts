import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InstituteDashboardNavBarComponent } from './institute-dashboard-nav-bar.component';

describe('InstituteDashboardNavBarComponent', () => {
  let component: InstituteDashboardNavBarComponent;
  let fixture: ComponentFixture<InstituteDashboardNavBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InstituteDashboardNavBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InstituteDashboardNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
