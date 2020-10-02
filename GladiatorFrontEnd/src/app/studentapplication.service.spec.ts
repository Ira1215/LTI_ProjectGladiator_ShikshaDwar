import { TestBed } from '@angular/core/testing';

import { StudentapplicationService } from './studentapplication.service';

describe('StudentapplicationService', () => {
  let service: StudentapplicationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudentapplicationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
