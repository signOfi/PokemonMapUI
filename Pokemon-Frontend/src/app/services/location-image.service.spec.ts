import { TestBed } from '@angular/core/testing';

import { LocationImageService } from './location-image.service';

describe('LocationImageService', () => {
  let service: LocationImageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LocationImageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
