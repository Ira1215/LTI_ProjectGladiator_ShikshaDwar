import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InstituteTrackApplicationStatusComponent } from './institute-track-application-status.component';

describe('InstituteTrackApplicationStatusComponent', () => {
  let component: InstituteTrackApplicationStatusComponent;
  let fixture: ComponentFixture<InstituteTrackApplicationStatusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InstituteTrackApplicationStatusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InstituteTrackApplicationStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
