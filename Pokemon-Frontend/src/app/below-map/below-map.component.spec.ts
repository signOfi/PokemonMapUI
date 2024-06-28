import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BelowMapComponent } from './below-map.component';

describe('BelowMapComponent', () => {
  let component: BelowMapComponent;
  let fixture: ComponentFixture<BelowMapComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BelowMapComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BelowMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
