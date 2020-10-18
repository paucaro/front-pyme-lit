import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IniciocliComponent } from './iniciocli.component';

describe('IniciocliComponent', () => {
  let component: IniciocliComponent;
  let fixture: ComponentFixture<IniciocliComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IniciocliComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IniciocliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
