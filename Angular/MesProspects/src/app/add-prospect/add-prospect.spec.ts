import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddProspect } from './add-prospect';

describe('AddProspect', () => {
  let component: AddProspect;
  let fixture: ComponentFixture<AddProspect>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddProspect],
    }).compileComponents();

    fixture = TestBed.createComponent(AddProspect);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
