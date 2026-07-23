import { TestBed } from '@angular/core/testing';

import { Auth } from './auth';

describe('Auth', () => {
  let service: Auth;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Auth);
    localStorage.clear();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should restore logged state from persisted jwt on load', () => {
    const payload = {
      sub: 'admin',
      roles: ['ADMIN']
    };
    const token = `eyJhbGciOiJub25lIn0.${btoa(JSON.stringify(payload))}.signature`;

    localStorage.setItem('jwt', token);

    service.loadToken();

    expect(service.isloggedIn).toBeTrue();
    expect(service.loggedUser).toBe('admin');
    expect(service.roles).toEqual(['ADMIN']);
  });
});
