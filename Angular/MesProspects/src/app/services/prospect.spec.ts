import { TestBed } from '@angular/core/testing';

import { Prospect } from './prospect';

describe('Prospect', () => {
  let service: Prospect;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Prospect);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
