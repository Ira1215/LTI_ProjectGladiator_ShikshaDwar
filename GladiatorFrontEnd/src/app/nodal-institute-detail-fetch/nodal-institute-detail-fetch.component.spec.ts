import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NodalInstituteDetailFetchComponent } from './nodal-institute-detail-fetch.component';

describe('NodalInstituteDetailFetchComponent', () => {
  let component: NodalInstituteDetailFetchComponent;
  let fixture: ComponentFixture<NodalInstituteDetailFetchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NodalInstituteDetailFetchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NodalInstituteDetailFetchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
