import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MinistryInstituteDetailFetchComponent } from './ministry-institute-detail-fetch.component';

describe('MinistryInstituteDetailFetchComponent', () => {
  let component: MinistryInstituteDetailFetchComponent;
  let fixture: ComponentFixture<MinistryInstituteDetailFetchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MinistryInstituteDetailFetchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MinistryInstituteDetailFetchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
