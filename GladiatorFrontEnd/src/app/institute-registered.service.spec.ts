import { TestBed } from '@angular/core/testing';

import { InstituteRegisteredService } from './institute-registered.service';

describe('InstituteRegisteredService', () => {
  let service: InstituteRegisteredService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InstituteRegisteredService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
