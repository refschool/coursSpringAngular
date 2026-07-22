import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { prospectGuard } from './prospect-guard';

describe('prospectGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) =>
    TestBed.runInInjectionContext(() => prospectGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
