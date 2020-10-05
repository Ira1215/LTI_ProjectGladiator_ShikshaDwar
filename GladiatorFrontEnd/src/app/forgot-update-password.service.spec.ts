import { TestBed } from '@angular/core/testing';

import { ForgotUpdatePasswordService } from './forgot-update-password.service';

describe('ForgotUpdatePasswordService', () => {
  let service: ForgotUpdatePasswordService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ForgotUpdatePasswordService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
