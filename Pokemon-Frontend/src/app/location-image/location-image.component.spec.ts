import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LocationImageComponent } from './location-image.component';

describe('LocationImageComponent', () => {
  let component: LocationImageComponent;
  let fixture: ComponentFixture<LocationImageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LocationImageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LocationImageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
