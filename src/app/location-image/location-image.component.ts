import { Component, Input } from '@angular/core';
import { LocationDTO } from '../models/locationDTO';
import { LocationImageService } from '../services/location-image.service';

@Component({
  selector: 'app-location-image',
  templateUrl: './location-image.component.html',
  styleUrls: ['./location-image.component.css']
})
export class LocationImageComponent {
  @Input() location!: LocationDTO | LocationDTO[];

  constructor(private locationImageService: LocationImageService) {}

  getCurrentLocation(): LocationDTO {
    return Array.isArray(this.location) ? this.location[0] : this.location;
  }

  getImagePath(): string {
    const currentLocation = this.getCurrentLocation();
    if (currentLocation && currentLocation.name) {
      return this.locationImageService.getImagePath(currentLocation.name);
    }
    return 'assets/locationImages/default.png';
  }
}
